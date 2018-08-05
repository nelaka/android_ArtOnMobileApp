package com.example.android.android_artonmobileapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;

import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Implementation of App Widget functionality.
 */
public class ArtOnMobileWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, String imageUrl, int appWidgetId) {

        // Create an Intent to launch FavActivity when clicked
        Intent intent = new Intent(context, FavActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.art_on_mobile_widget);


        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.appwidget_image, pendingIntent);

        // Add the showArtObjectService click handler
        Intent showArtObjectIntent = new Intent(context, WidgetServices.class);
        showArtObjectIntent.setAction(WidgetServices.ACTION_SHOW_ART_OBJECT);
        PendingIntent showArtObjectPendingIntent = PendingIntent.getService(
                context,
                0,
                showArtObjectIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Update image

     //   views.setImageViewUri(R.id.appwidget_image, Uri.parse(imageUrl));
        Picasso.get()
                .load(imageUrl)
                .resize(100, 100)
                .into(views, R.id.appwidget_image, new int[] {appWidgetId});
//views.setImageViewResource(R.id.appwidget_image, R.drawable.artonmobile_launcher);*/
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Start the intent service update widget action, the service takes care of updating the widgets UI
        WidgetServices.startActionShowArtObject(context);

    }

    public static void updateArtObjectWidgets(Context context, AppWidgetManager appWidgetManager,
                                          String imageUrl, int[] appWidgetIds) {
      for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, imageUrl, appWidgetId);
        }

    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // Perform any action when one or more AppWidget instances have been deleted
    }

    @Override
    public void onEnabled(Context context) {
        // Perform any action when an AppWidget for this provider is instantiated
    }

    @Override
    public void onDisabled(Context context) {
        // Perform any action when the last AppWidget instance for this provider is deleted
    }
}

