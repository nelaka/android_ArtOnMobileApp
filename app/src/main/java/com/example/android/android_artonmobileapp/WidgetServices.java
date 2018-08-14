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

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import com.example.android.android_artonmobileapp.data.ArtObjectsContract;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class WidgetServices extends IntentService {

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_NEXT_ART_OBJECT = "com.example.android.android_artonmobileapp.action.CHANGE_IMAGE_NEXT";
    public static final String ACTION_PREV_ART_OBJECT = "com.example.android.android_artonmobileapp.action.CHANGE_IMAGE_PREV";
    public static final String ACTION_SHOW_ART_OBJECT = "com.example.android.android_artonmobileapp.action.SHOW_IMAGE";
    public static final String ART_OBJECT_POSITION = "com.example.android.android_artonmobileapp.extra.POSITION";

    public WidgetServices() {
        super("WidgetServices");
    }

    /**
     * Starts this service to perform action Previous Art Object with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionPrevArtObject(Context context, int position) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_PREV_ART_OBJECT);
        intent.putExtra(ART_OBJECT_POSITION, position);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Next Art Object with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionNextArtObject(Context context, int position) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_NEXT_ART_OBJECT);
        intent.putExtra(ART_OBJECT_POSITION, position);

        context.startService(intent);
    }

    /**
     * Starts this service to perform action Show Art Object with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionShowArtObject(Context context) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_SHOW_ART_OBJECT);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int position;
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_NEXT_ART_OBJECT.equals(action)) {
                position = intent.getIntExtra(ART_OBJECT_POSITION, 0);
                handleActionNextArtObject(position);

            } else if (ACTION_SHOW_ART_OBJECT.equals(action)) {
                handleActionShowArtObject();

            } else if (ACTION_PREV_ART_OBJECT.equals(action)) {
                position = intent.getIntExtra(ART_OBJECT_POSITION, 0);
                handleActionPrevArtObject(position);

            }
        }
    }

    /**
     * Handle action Previous Art Object in the provided background thread with the provided
     * parameters.
     */
    private void handleActionPrevArtObject(int position) {
        String imageUrl = null;
        String title = getResources().getString(R.string.widget_msg_no_fav);

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);

        if (itemsResponse.getCount() > 0) {
            if (position > 0) {
                position--;
            } else {
                position = 0;
            }
            itemsResponse.moveToPosition(position);

            int itemImageIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);
            imageUrl = itemsResponse.getString(itemImageIndex);
            int itemTitleIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
            title = itemsResponse.getString(itemTitleIndex);
        }
        itemsResponse.close();

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtOnMobileWidget.class));
        //Now update all widgets
        ArtOnMobileWidget.updateArtObjectWidgets(this, appWidgetManager, position, imageUrl, title, appWidgetIds);
    }

    /**
     * Handle action Next Art Object in the provided background thread with the provided
     * parameters.
     */
    private void handleActionNextArtObject(int position) {
        String imageUrl = null;
        String title = getResources().getString(R.string.widget_msg_no_fav);

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);

        if (itemsResponse.getCount() > 0) {
            if (position < itemsResponse.getCount() - 1) {
                position++;
            } else {
                position = itemsResponse.getCount() - 1;
            }
            itemsResponse.moveToPosition(position);

            int itemImageIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);
            imageUrl = itemsResponse.getString(itemImageIndex);
            int itemTitleIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
            title = itemsResponse.getString(itemTitleIndex);
        }
        itemsResponse.close();

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtOnMobileWidget.class));
        //Now update all widgets
        ArtOnMobileWidget.updateArtObjectWidgets(this, appWidgetManager, position, imageUrl, title, appWidgetIds);
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionShowArtObject() {

        String imageUrl = null;
        String title = getResources().getString(R.string.widget_msg_no_fav);

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);

        if (itemsResponse.getCount() > 0) {
            itemsResponse.moveToPosition(0);

            int itemImageIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);
            imageUrl = itemsResponse.getString(itemImageIndex);
            int itemTitleIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
            title = itemsResponse.getString(itemTitleIndex);
        }
        itemsResponse.close();

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtOnMobileWidget.class));
        //Now update all widgets
        ArtOnMobileWidget.updateArtObjectWidgets(this, appWidgetManager, 0, imageUrl, title, appWidgetIds);
    }
}