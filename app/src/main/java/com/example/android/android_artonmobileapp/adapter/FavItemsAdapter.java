/*Copyright 2018 Eleni Kalkopoulou

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
  */
package com.example.android.android_artonmobileapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.database.FavArtObjectEntry;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;

import java.util.List;

public class FavItemsAdapter extends RecyclerView.Adapter<FavItemViewHolder> {

    private static final String TAG = FavItemsAdapter.class.getSimpleName();

    private final Context mContext;
    private final FavItemViewHolder.FavItemsAdapterOnClickHandler mClickHandler;
    // Class variables for the List that holds task data and the Context
    private List<FavArtObjectEntry> mFavArtObjectEntries;

    /**
     * Constructor for the FavItemsAdapter that initializes the Context.
     * @param context  the current Context
     * @param clickHandler the FavItemClickListener
     */
    public FavItemsAdapter(@NonNull Context context, FavItemViewHolder.FavItemsAdapterOnClickHandler clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;
    }

    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     * @return A new TaskViewHolder that holds the view for each task
     */
    @NonNull
    @Override
    public FavItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fav_list_item, viewGroup, false);

        view.setFocusable(true);
        return new FavItemViewHolder(view, mClickHandler, mFavArtObjectEntries);
    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */

    @Override
    public void onBindViewHolder(@NonNull FavItemViewHolder holder, int position) {
        FavArtObjectEntry favArtObjectEntry = mFavArtObjectEntries.get(position);

        String image_url = favArtObjectEntry.getImageUrl();
        holder.bindArtObjects(image_url);
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setData(List<FavArtObjectEntry> favArtObjectEntries) {
        mFavArtObjectEntries = favArtObjectEntries;
        notifyDataSetChanged();
    }

    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mFavArtObjectEntries == null) {
            return 0;
        }
        return mFavArtObjectEntries.size();
    }
}