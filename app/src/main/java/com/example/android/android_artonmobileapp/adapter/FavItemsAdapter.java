package com.example.android.android_artonmobileapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_artonmobileapp.MainActivity;
import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_ART_OBJECT_ID;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_MAKER;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE_LONG;

public class FavItemsAdapter extends RecyclerView.Adapter<FavItemViewHolder> {
    private static final String TAG = FavItemsAdapter.class.getSimpleName();
    private static final String POSTER_WIDTH = "w185";
    private static final String POSTER_IMAGES_URL = "http://image.tmdb.org/t/p";

    /* The context we use to utility methods, app resources and layout inflaters */
    private final Context mContext;
    private final FavItemViewHolder.FavItemsAdapterOnClickHandler mClickHandler;
    private List<ArtObject> mFavItems = new ArrayList<>();
    private Cursor mCursor;

    // Create a String array containing the names of the desired data columns from our ContentProvider
    public static final String[] FAV_OBJECTS_PROJECTION = {
            ArtObjectsContract.ArtObjectsEntry.COLUMN_ART_OBJECT_ID,
            ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE,
            ArtObjectsContract.ArtObjectsEntry.COLUMN_MAKER,
            ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE
    };

    //Create constant int values representing each column name's position above
    /*
     * We store the indices of the values in the array of Strings above to more quickly be able to
     * access the data from our query. If the order of the Strings above changes, these indices
     * must be adjusted to match the order of the Strings.
     */
    public static final int INDEX_ART_OBJECT_ID = 0;
    public static final int INDEX_ART_OBJECT_TITLE = 1;
    public static final int INDEX_ART_OBJECT_MAKER = 2;
    public static final int INDEX_ART_OBJECT_IMAGE = 3;



    public FavItemsAdapter(@NonNull Context context, FavItemViewHolder.FavItemsAdapterOnClickHandler clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;
    }

    public FavItemsAdapter(@NonNull Context context, Cursor cursor, FavItemViewHolder.FavItemsAdapterOnClickHandler clickHandler) {
        mContext = context;
        mCursor = cursor;
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public FavItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);

        view.setFocusable(true);
        return new FavItemViewHolder(view, mClickHandler, mFavItems);
    }

    @Override
    public void onBindViewHolder(@NonNull FavItemViewHolder holder, int position) {
        // Move the cursor to the appropriate position
        mCursor.moveToPosition(position);

        // Generate a weather summary with the date, description, high and low
        /* Read date from the cursor */
        String id = mCursor.getString(INDEX_ART_OBJECT_ID);
        /* Get human readable string using our utility method */
        String title = mCursor.getString(INDEX_ART_OBJECT_TITLE);
        String maker = mCursor.getString(INDEX_ART_OBJECT_MAKER);
        String image_url = mCursor.getString(INDEX_ART_OBJECT_IMAGE);

        holder.bindArtObjects(image_url);
    }

    @Override
    public int getItemCount() {
        if (null == mFavItems) return 0;
        return mFavItems.size();
    }

    /**
     * This method is used to set the movies on a MoviesAdapter if we've already
     * created one.
     *
     * @param cursor The new movie data to be displayed.
     */
    public void setData(Cursor cursor) {
      //  data = new ArrayList<>();
        for (int i = 0; i < cursor.getCount(); i++) {
            int itemIdIndex = cursor.getColumnIndex(COLUMN_ART_OBJECT_ID);
            int itemTitleIndex = cursor.getColumnIndex(COLUMN_TITLE);
            int itemMakerIndex = cursor.getColumnIndex(COLUMN_MAKER);
            int itemTitleLongIndex = cursor.getColumnIndex(COLUMN_TITLE_LONG);
            int itemImageIndex = cursor.getColumnIndex(COLUMN_IMAGE);

            cursor.moveToPosition(i);

            mFavItems.add(new ArtObject(cursor.getString(itemIdIndex), cursor.getString(itemTitleIndex), cursor.getString(itemMakerIndex), cursor.getString(itemTitleLongIndex), cursor.getString(itemImageIndex)));

        }
       // notifyDataSetChanged();

    }

    /**
     * Swaps the cursor used by the ForecastAdapter for its weather data. This method is called by
     * MainActivity after a load has finished, as well as when the Loader responsible for loading
     * the weather data is reset. When this method is called, we assume we have a completely new
     * set of data, so we call notifyDataSetChanged to tell the RecyclerView to update.
     *
     * @param newCursor the new cursor to use as ForecastAdapter's data source
     */
    public void swapCursor(Cursor newCursor) {
        mCursor = newCursor;

        notifyDataSetChanged();
    }
}