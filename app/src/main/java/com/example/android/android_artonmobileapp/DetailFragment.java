package com.example.android.android_artonmobileapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.adapter.ArtObjectsAdapter;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.model.ArtObjectDetail;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    ArtObject mItem;
    ArtObjectDetail mDetails;
    ArrayList mColors = new ArrayList<>();
    @BindView(R.id.art_object_iv)
    ImageView mArtObjectView;
    @BindView(R.id.art_object_desc_tv)
    TextView mArtObjectDescView;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.pb_loading_indicator)
    ProgressBar mLoadingIndicator;
    Boolean mFavorite = false;
 private Context mContext;
  //  private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);

        Intent intent = getActivity().getIntent();

        if (intent != null) {
            if (intent.hasExtra(Config.BUNDLE_ART_OBJECT)) {
                mItem = intent.getParcelableExtra(Config.BUNDLE_ART_OBJECT);

                // Display the current selected movie title on the Action Bar
                //      getSupportActionBar()
                mToolbar.setTitle(mItem.getTitle());
                String url = mItem.getWebImage().getUrl();
                Log.v("adapterART OBJECT", "url = " + url);

                Picasso.get().load(url).placeholder(R.drawable.placeholder1200).error(R.drawable.placeholder1200).into(mArtObjectView);

                mArtObjectDescView.setText(mItem.getTitle());

            }
        }
        //mFavorite = isFavorite(mMovie);

        // Setup FAB to open EditorActivity
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFavorite) {
                    fab.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    //      removeMovieFromFavorites(mMovie);
                } else {
                    fab.setImageResource(R.drawable.ic_favorite_white_24dp);
                    //    addMovieToFavorites(mMovie);
                }
            }
        });
        artObjectDetailsRequest();
        return rootView;
    }

    private void artObjectDetailsRequest() {


        if (mDetails == null) {

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<ArtObjectDetail> call = apiService.getArtObjectDetails(mItem.getObjectNumber(), Config.rijksmuseumApiKey, "json");
            call.enqueue(new Callback<ArtObjectDetail>() {

                @Override
                public void onResponse(@NonNull Call<ArtObjectDetail> call, @NonNull Response<ArtObjectDetail> response) {
                    mColors = response.body().getColors();
                    Log.d("DETAIL ", "Number of colors results received: " + mDetails.getColors().size());
                    mLoadingIndicator.setVisibility(View.INVISIBLE);

                /*    if (mItems != null) {
                        mArtObjectsAdapter.setData(mItems);

                        /* Setting the adapter attaches it to the RecyclerView in our layout. */
                   /*     mRecyclerView.setAdapter(mArtObjectsAdapter);
                        showDataView();

                    } else {
                        showErrorMessage();
                    }*/
                }

                @Override
                public void onFailure(@NonNull Call<ArtObjectDetail> call, @NonNull Throwable t) {

                    // mLoadingIndicator.setVisibility(View.INVISIBLE);
                    //showErrorMessage();

                    // Log error here since request failed
                    Log.e("detail", t.toString());
                }
            });
        } else {
            //mLoadingIndicator.setVisibility(View.INVISIBLE);
            //mArtObjectsAdapter.setData(mItems);

            /* Setting the adapter attaches it to the RecyclerView in the layout. */
            //   mRecyclerView.getLayoutManager().onRestoreInstanceState(mSavedRecyclerLayoutState);

            //  mRecyclerView.setAdapter(mArtObjectsAdapter);
            //showDataView();
        }
    }


 /*   @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
 /*   public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
