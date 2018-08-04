package com.example.android.android_artonmobileapp.holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final FavItemsAdapterOnClickHandler mClickHandler;
    private final List<ArtObject> mFavItems;
    @BindView(R.id.fav_list_item)
    ImageView artObjectView;

    public FavItemViewHolder(View view, FavItemsAdapterOnClickHandler clickHandler, List<ArtObject> items) {
        super(view);
        mClickHandler = clickHandler;
        mFavItems = items;
        ButterKnife.bind(this, view);
        view.setOnClickListener(this);
    }

    public void bindArtObjects(String url) {
        //ArtObject artObject = mFavItems.get(position);

        //String url = artObject.getWebImage();
        Log.v("adapterART OBJECT", "url = " + url);

        Picasso.get().load(url).placeholder(R.drawable.placeholder1200).error(R.drawable.placeholder1200).into(artObjectView);

    }

    @Override
    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        mClickHandler.onClick(mFavItems.get(adapterPosition));
    }


    /**
     * The interface that receives onClick messages.
     */
    public interface FavItemsAdapterOnClickHandler {
        void onClick(ArtObject item);
    }
}