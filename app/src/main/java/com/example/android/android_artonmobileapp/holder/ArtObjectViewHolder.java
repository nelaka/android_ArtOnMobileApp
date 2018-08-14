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

    public void bindArtObjects(int position) {
        ArtObject artObject = mArtObjects.get(position);

        String url = artObject.getWebImage().getUrl();
        Log.v(TAG, "ART OBJECT URL: " + url);

        Picasso.get().load(url).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(artObjectView);
        /**
         * Content Descriptions for people with disabilities
         */
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