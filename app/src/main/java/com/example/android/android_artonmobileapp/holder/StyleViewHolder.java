package com.example.android.android_artonmobileapp.holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.android_artonmobileapp.R;
import com.example.android.android_artonmobileapp.model.Style;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StyleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final StylesAdapterOnClickHandler mClickHandler;

    private final List<Style> mStyles;

    //  @BindView(R.id.artist_iv)
    //ImageView artistImageView;
    @BindView(R.id.style_list_item)
    ImageView styleImageView;

    public StyleViewHolder(View itemView, StylesAdapterOnClickHandler clickHandler, List<Style> styles) {
        super(itemView);

        mClickHandler = clickHandler;
        mStyles = styles;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);

    }

    public void bindStyles(int position) {
        Style style = mStyles.get(position);

        String url = style.getImage().getUrl();
        Log.v("adapterSTYLE", "url = " + url);

        Picasso.get().load(url).placeholder(R.drawable.placeholder1200).error(R.drawable.placeholder1200).into(styleImageView);

        //artistTextView.setText(style.getTitle());

    }

    @Override
    public void onClick(View v) {
        int adapterPosition = getAdapterPosition();
        mClickHandler.onClick(mStyles.get(adapterPosition));
    }

    /**
     * The interface that receives onClick messages.
     */
    public interface StylesAdapterOnClickHandler {
        void onClick(Style style);
    }
}

