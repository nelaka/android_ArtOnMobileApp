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
    private static String mImageUrl;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, String imageUrl, int appWidgetId) {
mImageUrl = imageUrl;
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.art_on_mobile_widget);

        // Create an Intent to launch FavActivity when clicked
        Intent intent = new Intent(context, FavActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Add the showArtObjectService click handler
        Intent showArtObjectIntent = new Intent(context, WidgetServices.class);
        showArtObjectIntent.setAction(WidgetServices.ACTION_SHOW_ART_OBJECT);
        PendingIntent showArtObjectPendingIntent = PendingIntent.getService(
                context,
                0,
                showArtObjectIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.appwidget_image, showArtObjectPendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, mImageUrl, appWidgetId);
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

