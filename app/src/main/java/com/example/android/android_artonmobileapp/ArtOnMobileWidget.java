/**Copyright 2018 Eleni Kalkopoulou

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 * */
package com.example.android.android_artonmobileapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;

/**
 * Implementation of App Widget functionality.
 */
public class ArtOnMobileWidget extends AppWidgetProvider {
    private static String mImageUrl;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int position, String imageUrl, String title, final int appWidgetId) {

        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.art_on_mobile_widget);

        // Create an Intent to launch FavActivity when clicked
        if (imageUrl != null) {
            Intent intent = new Intent(context, FavActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Widgets allow click handlers to only launch pending intents
            views.setOnClickPendingIntent(R.id.appwidget_image, pendingIntent);
        }

        // Add the showArtObjectService click handler
        Intent showArtObjectIntent = new Intent(context, WidgetServices.class);
        showArtObjectIntent.setAction(WidgetServices.ACTION_SHOW_ART_OBJECT);
        // Update image
        PendingIntent showArtObjectPendingIntent = PendingIntent.getService(context, 0, showArtObjectIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (imageUrl != null) {
            mImageUrl = imageUrl;
        } else {
            //provide a placeholder when there are no images
            mImageUrl = "http://via.placeholder.com/200x200";
        }

        Handler uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(mImageUrl).resize(200, 200).into(views, R.id.appwidget_image, new int[]{appWidgetId});
            }
        });

        views.setTextViewText(R.id.appwidget_text, title);

        //Update the current widget instance only, by creating an array that contains the widget’s unique ID//
        int[] idArray = new int[]{appWidgetId};

        // Add the prevArtObjectService click handler
        Intent prevArtObjectIntent = new Intent(context, WidgetServices.class);
        prevArtObjectIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
        prevArtObjectIntent.putExtra(WidgetServices.ART_OBJECT_POSITION, position);
        prevArtObjectIntent.setAction(WidgetServices.ACTION_PREV_ART_OBJECT);
        PendingIntent prevArtObjectPendingIntent = PendingIntent.getService(context, 0, prevArtObjectIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.widget_previous_button, prevArtObjectPendingIntent);

        // Add the nextArtObjectService click handler
        Intent nextArtObjectIntent = new Intent(context, WidgetServices.class);
        nextArtObjectIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
        nextArtObjectIntent.putExtra(WidgetServices.ART_OBJECT_POSITION, position);
        nextArtObjectIntent.setAction(WidgetServices.ACTION_NEXT_ART_OBJECT);
        PendingIntent nextArtObjectPendingIntent = PendingIntent.getService(context, 0, nextArtObjectIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.widget_next_button, nextArtObjectPendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public static void updateArtObjectWidgets(Context context, AppWidgetManager appWidgetManager, int position, String imageUrl, String title, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, position, imageUrl, title, appWidgetId);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        //Start the intent service update widget action, the service takes care of updating the widgets UI
        WidgetServices.startActionShowArtObject(context);
    }
}