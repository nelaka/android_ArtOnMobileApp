package com.example.android.android_artonmobileapp.holder;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final FavItemsAdapterOnClickHandler mClickHandler;
    @BindView(R.id.fav_list_item)
    ImageView artObjectView;
    private Cursor mCursor;

    public FavItemViewHolder(View view, FavItemsAdapterOnClickHandler clickHandler, Cursor cursor) {
        super(view);
        mClickHandler = clickHandler;
        mCursor = cursor;
        ButterKnife.bind(this, view);
        view.setOnClickListener(this);
    }

    public void bindArtObjects(String url) {
        Picasso.get().load(url).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(artObjectView);
    }

    @Override
    public void onClick(View view) {
        ArtObject artObject = new ArtObject();
        int adapterPosition = getAdapterPosition();

        mCursor.moveToPosition(adapterPosition);

        int itemIdIndex = mCursor.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_ART_OBJECT_ID);
        int itemTitleIndex = mCursor.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE);
        int itemMakerIndex = mCursor.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_MAKER);
        int itemImageIndex = mCursor.getColumnIndex(ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE);

        artObject.setId(mCursor.getString(itemIdIndex));
        artObject.setTitle(mCursor.getString(itemTitleIndex));
        artObject.setPrincipalOrFirstMaker(mCursor.getString(itemMakerIndex));
        artObject.setImage(mCursor.getString(itemImageIndex));
        //mCursor.close();
        mClickHandler.onClick(artObject);
    }

    /**
     * The interface that receives onClick messages.
     */
    public interface FavItemsAdapterOnClickHandler {
        void onClick(ArtObject artObject);
    }
}