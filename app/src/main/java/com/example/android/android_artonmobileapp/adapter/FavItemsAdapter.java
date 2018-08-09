package com.example.android.android_artonmobileapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;

public class FavItemsAdapter extends RecyclerView.Adapter<FavItemViewHolder> {

    private static final String TAG = FavItemsAdapter.class.getSimpleName();

    // Create a String array containing the names of the desired data columns from our ContentProvider
    public static final String[] FAV_OBJECTS_PROJECTION = {
            ArtObjectsEntry.COLUMN_ART_OBJECT_ID,
            ArtObjectsEntry.COLUMN_TITLE,
            ArtObjectsEntry.COLUMN_MAKER,
            ArtObjectsEntry.COLUMN_IMAGE};

    //Create constant int values representing each column name's position above
    /*
     * We store the indices of the values in the array of Strings above to more quickly be able to
     * access the data from our query. If the order of the Strings above changes, these indices
     * must be adjusted to match the order of the Strings.
     */
    public static final int INDEX_ART_OBJECT_ID = 0;
    private static final int INDEX_ART_OBJECT_TITLE = 1;
    private static final int INDEX_ART_OBJECT_MAKER = 2;
    private static final int INDEX_ART_OBJECT_IMAGE = 3;

    private final Context mContext;
    private final FavItemViewHolder.FavItemsAdapterOnClickHandler mClickHandler;
    private Cursor mCursor;

    public FavItemsAdapter(@NonNull Context context, FavItemViewHolder.FavItemsAdapterOnClickHandler clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public FavItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fav_list_item, viewGroup, false);

        view.setFocusable(true);
        return new FavItemViewHolder(view, mClickHandler, mCursor);
    }

    @Override
    public void onBindViewHolder(@NonNull FavItemViewHolder holder, int position) {
        // Move the cursor to the appropriate position
        mCursor.moveToPosition(position);
        String image_url = mCursor.getString(INDEX_ART_OBJECT_IMAGE);
        holder.bindArtObjects(image_url);
    }

    @Override
    public int getItemCount() {
        if (null == mCursor) return 0;
        return mCursor.getCount();
    }

    /**
     * Swaps the cursor used by the FavAdapter for the favorite art objects. This method is called by
     * MainActivity after a load has finished, as well as when the Loader responsible for loading
     * the art object data is reset. When this method is called, we assume we have a completely new
     * set of data, so we call notifyDataSetChanged to tell the RecyclerView to update.
     *
     * @param newCursor the new cursor to use as FavAdapter's data source
     */
    public void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }
}