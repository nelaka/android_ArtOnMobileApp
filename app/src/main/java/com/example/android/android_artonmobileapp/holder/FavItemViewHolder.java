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

        mClickHandler.onClick(artObject);
    }

    /**
     * The interface that receives onClick messages.
     */
    public interface FavItemsAdapterOnClickHandler {
        void onClick(ArtObject artObject);
    }
}