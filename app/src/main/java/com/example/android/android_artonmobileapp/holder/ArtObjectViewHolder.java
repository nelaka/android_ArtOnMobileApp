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

public class ArtObjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = ArtObjectViewHolder.class.getSimpleName();

    private final ArtObjectAdapterOnClickHandler mClickHandler;

        private final List<ArtObject> mArtObjects;
        @BindView(R.id.list_item)
        ImageView artObjectView;


        public ArtObjectViewHolder(View itemView, ArtObjectAdapterOnClickHandler clickHandler, List<ArtObject> artObjects) {
            super(itemView);

            mClickHandler = clickHandler;
            mArtObjects = artObjects;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindArtObjects (int position) {
            ArtObject artObject = mArtObjects.get(position);

            String url = artObject.getWebImage().getUrl();
            Log.v("adapterART OBJECT", "url = " + url );

            Picasso.get().load(url).placeholder(R.drawable.placeholder).error(R.drawable.placeholder)
                    .into(artObjectView);

            artObjectView.setContentDescription(artObject.getTitle());

        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(mArtObjects.get(adapterPosition));
        }

        /**
         * The interface that receives onClick messages.
         */
        public interface ArtObjectAdapterOnClickHandler {
            void onClick(ArtObject artObject);
        }
    }
