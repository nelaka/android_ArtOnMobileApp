package com.example.android.android_artonmobileapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;

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
        holder.bindArtObjects(position);
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
    public void setData(List<ArtObject> data) {
        data = new ArrayList<>();


        for (int i = 0; i < mCursor.getCount(); i++) {
            int itemIdIndex = mCursor.getColumnIndex(COLUMN_ART_OBJECT_ID);
            int itemTitleIndex = mCursor.getColumnIndex(COLUMN_TITLE);
            int itemMakerIndex = mCursor.getColumnIndex(COLUMN_MAKER);
            int itemTitleLongIndex = mCursor.getColumnIndex(COLUMN_TITLE_LONG);
            int itemImageIndex = mCursor.getColumnIndex(COLUMN_IMAGE);

            mCursor.moveToPosition(i);

            data.add(new ArtObject(mCursor.getString(itemIdIndex), mCursor.getString(itemTitleIndex), mCursor.getString(itemMakerIndex), mCursor.getString(itemTitleLongIndex), mCursor.getString(itemImageIndex)));

        }
        notifyDataSetChanged();

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