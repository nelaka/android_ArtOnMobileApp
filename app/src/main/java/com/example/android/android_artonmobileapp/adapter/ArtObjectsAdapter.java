package com.example.android.android_artonmobileapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.holder.ArtObjectViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;

import java.util.ArrayList;
import java.util.List;

public class ArtObjectsAdapter extends RecyclerView.Adapter<ArtObjectViewHolder> {

    private static final String TAG = ArtObjectsAdapter.class.getSimpleName();
    private final Context mContext;
    private final ArtObjectViewHolder.ArtObjectAdapterOnClickHandler mClickHandler;
    private List<ArtObject> mArtObjects = new ArrayList<>();

    public ArtObjectsAdapter(ArtObjectViewHolder.ArtObjectAdapterOnClickHandler clickHandler, Context context) {
        mClickHandler = clickHandler;
        mContext = context;
    }

    @NonNull
    @Override
    public ArtObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        view.setFocusable(true);
        return new ArtObjectViewHolder(view, mClickHandler, mArtObjects);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtObjectViewHolder holder, int position) {

        holder.bindArtObjects(position);
    }

    @Override
    public int getItemCount() {
        if (null == mArtObjects) return 0;
        return mArtObjects.size();
    }

    /**
     * This method is used to set the art objects on an ArtObjectAdapter if we've already
     * created one.
     *
     * @param data The new art objects data to be displayed.
     */
    public void setData(List<ArtObject> data) {
        mArtObjects = data;
        notifyDataSetChanged();
    }
}