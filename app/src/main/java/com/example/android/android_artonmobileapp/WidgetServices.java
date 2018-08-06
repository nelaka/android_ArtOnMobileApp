package com.example.android.android_artonmobileapp;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.model.ArtObject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class WidgetServices extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_NEXT_ART_OBJECT = "com.example.android.android_artonmobileapp.action.CHANGE_IMAGE_NEXT";
    public static final String ACTION_PREV_ART_OBJECT = "com.example.android.android_artonmobileapp.action.CHANGE_IMAGE_PREV";
    public static final String ACTION_SHOW_ART_OBJECT = "com.example.android.android_artonmobileapp.action.SHOW_IMAGE";

    // TODO: Rename parameters
    private static final String ART_OBJECT_ID = "com.example.android.android_artonmobileapp.extra.ID";
    public static final String ART_OBJECT_POSITION = "com.example.android.android_artonmobileapp.extra.POSITION";

    public WidgetServices() {
        super("WidgetServices");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionPrevArtObject(Context context, int position /*, String nextId*/) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_PREV_ART_OBJECT);
        intent.putExtra(ART_OBJECT_POSITION, position);

        context.startService(intent);
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionNextArtObject(Context context, int position) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_NEXT_ART_OBJECT);
        intent.putExtra(ART_OBJECT_POSITION, position);

        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionShowArtObject(Context context) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_SHOW_ART_OBJECT);
       // intent.putExtra(ART_OBJECT_POSITION, position);
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
                position = intent.getIntExtra(ART_OBJECT_POSITION, 0);
                handleActionShowArtObject();
            }
            else if(ACTION_PREV_ART_OBJECT.equals(action)) {

                position = intent.getIntExtra(ART_OBJECT_POSITION, 0);

                handleActionPrevArtObject(position);
            }
        }
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionPrevArtObject(int position) {
        //String[] args = { id };

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        //  Cursor itemsResponse = resolver.query(uri, null, "id=?", args, null);
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);

       if ( position > 0)
           position--;
       else position = 0;
        itemsResponse.moveToPosition(position);


        int itemImageIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);
        String imageUrl = itemsResponse.getString(itemImageIndex);
        int itemTitleIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
        String title = itemsResponse.getString(itemTitleIndex);
        Log.v("WIDGET SERVICE","WIDGET CURSOR:" + position );

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtOnMobileWidget.class));
        //Now update all widgets
        ArtOnMobileWidget.updateArtObjectWidgets(this, appWidgetManager, position, imageUrl, title, appWidgetIds);
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionNextArtObject(int position) {

       // String[] args = { Integer.toString(id+1)};

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
       // Cursor itemsResponse = resolver.query(uri, null, "_id=?", args, null);
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);
        if (position < itemsResponse.getCount() ) {
            position++;
        } else { position = itemsResponse.getCount() - 1 ; }
            itemsResponse.moveToPosition(position);
        int itemImageIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);
        String imageUrl = itemsResponse.getString(itemImageIndex);
        int itemTitleIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
        String title = itemsResponse.getString(itemTitleIndex);

        Log.v("WIDGET SERVICE","WIDGET CURSOR:" + position );

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

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);
        itemsResponse.moveToPosition(0);
        int itemImageIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);
        String imageUrl = itemsResponse.getString(itemImageIndex);
        int itemTitleIndex = itemsResponse.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
        String title = itemsResponse.getString(itemTitleIndex);




        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtOnMobileWidget.class));
        //Now update all widgets
        ArtOnMobileWidget.updateArtObjectWidgets(this, appWidgetManager, 0, imageUrl, title, appWidgetIds);
    }


}
