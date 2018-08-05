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
    public static final String ACTION_CHANGE_ART_OBJECT = "com.example.android.android_artonmobileapp.action.CHANGE_IMAGE";
    public static final String ACTION_SHOW_ART_OBJECT = "com.example.android.android_artonmobileapp.action.SHOW_IMAGE";

    // TODO: Rename parameters
    private static final String ART_OBJECT_ID = "com.example.android.android_artonmobileapp.extra.ID";
    private static final String ART_OBJECT_NEXT_ID = "com.example.android.android_artonmobileapp.extra.NEXT_ID";

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
    public static void startActionChangeArtObject(Context context, String id /*, String nextId*/) {
        Intent intent = new Intent(context, WidgetServices.class);
        intent.setAction(ACTION_CHANGE_ART_OBJECT);
        intent.putExtra(ART_OBJECT_ID, id);
        //intent.putExtra(ART_OBJECT_NEXT_ID, nextId);
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
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CHANGE_ART_OBJECT.equals(action)) {
                final String id = intent.getStringExtra(ART_OBJECT_ID);
                //final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionChangeArtObject(id /*, param2*/);
            } else if (ACTION_SHOW_ART_OBJECT.equals(action)) {

                handleActionShowArtObject();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionChangeArtObject(String id /*, String param2*/) {
        String[] args = { id + 1 };

        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, "id=?", args, null);

        if (itemsResponse.getCount() <= 0) {
            //showNoFavMovieMessage();
                  }
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
        Log.v("WIDGET SERVICE","WIDGET CURSOR:" + imageUrl );

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtOnMobileWidget.class));
        //Now update all widgets
        ArtOnMobileWidget.updateArtObjectWidgets(this, appWidgetManager, imageUrl, appWidgetIds);
    }


}
