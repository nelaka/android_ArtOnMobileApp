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

        // Create an Intent to launch FavActivity when clicked
        Intent intent = new Intent(context, FavActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.art_on_mobile_widget);


        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.appwidget_image, pendingIntent);

        // Add the showArtObjectService click handler
        Intent showArtObjectIntent = new Intent(context, WidgetServices.class);
        showArtObjectIntent.setAction(WidgetServices.ACTION_SHOW_ART_OBJECT);
        // Update image
        PendingIntent showArtObjectPendingIntent = PendingIntent.getService(context, 0, showArtObjectIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mImageUrl = imageUrl;

        views.setTextViewText(R.id.appwidget_text, title);
        //  views.setTextViewText(R.id.appwidget_text, Integer.toString(position));

        Handler uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(mImageUrl).resize(200, 200).into(views, R.id.appwidget_image, new int[]{appWidgetId});
            }
        });

        // Add the prevArtObjectService click handler
        Intent prevArtObjectIntent = new Intent(context, WidgetServices.class);
        prevArtObjectIntent.setAction(WidgetServices.ACTION_PREV_ART_OBJECT);
        PendingIntent prevArtObjectPendingIntent = PendingIntent.getService(context, 0, prevArtObjectIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.widget_previous_button, prevArtObjectPendingIntent);

        // Add the nextArtObjectService click handler
        Intent nextArtObjectIntent = new Intent(context, WidgetServices.class);
        nextArtObjectIntent.setAction(WidgetServices.ACTION_NEXT_ART_OBJECT);
        PendingIntent nextArtObjectPendingIntent = PendingIntent.getService(context, 0, nextArtObjectIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.widget_next_button, nextArtObjectPendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public static void updateArtObjectWidgets(Context context, AppWidgetManager appWidgetManager, int position, String imageUrl, String title, int[] appWidgetIds) {

        //  if (position > mPosition) WidgetServices.startActionNextArtObject(context, position);
        //  else if (position < mPosition) WidgetServices.startActionPrevArtObject(context, position);
        //  mPosition = position;
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, position, imageUrl, title, appWidgetId);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        //Start the intent service update widget action, the service takes care of updating the widgets UI
        WidgetServices.startActionShowArtObject(context);
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