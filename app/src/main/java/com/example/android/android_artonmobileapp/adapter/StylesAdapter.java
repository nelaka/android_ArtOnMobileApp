package com.example.android.android_artonmobileapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.holder.StyleViewHolder;
import com.example.android.android_artonmobileapp.model.Style;

import java.util.ArrayList;
import java.util.List;

public class StylesAdapter extends RecyclerView.Adapter<StyleViewHolder> {

    private final StyleViewHolder.StylesAdapterOnClickHandler mClickHandler;
    private final Context mContext;
    private List<Style> mStyles = new ArrayList<>();

    public StylesAdapter(Context context, StyleViewHolder.StylesAdapterOnClickHandler clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;

    }

    @NonNull
    @Override
    public StyleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.style_list_item, viewGroup, false);
        view.setFocusable(true);

        return new StyleViewHolder(view, mClickHandler, mStyles);

    }

    @Override
    public void onBindViewHolder(@NonNull StyleViewHolder holder, int position) {
        holder.bindStyles(position);

    }


    @Override
    public int getItemCount() {
        if (null == mStyles) return 0;
        return mStyles.size();

    }

    /**
     * This method is used to set the recipes on a RecipesAdapter if we've already
     * created one.
     *
     * @param data The new recipe data to be displayed.
     */
    public void setData(List<Style> data) {
        mStyles = data;
        notifyDataSetChanged();
    }


}














