package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ArtObjectResponse implements Parcelable {

    @SerializedName("count")
        private Integer mCount;
        @SerializedName("countFacets")
        private CountFacets mCountFacets;
        @SerializedName("artObjects")
        private ArrayList<ArtObject> mArtObjects = null;
        @SerializedName("facets")
        private List<Facet> mFacets = null;

        public final static Parcelable.Creator<ArtObjectResponse> CREATOR = new Creator<ArtObjectResponse>() {
            public ArtObjectResponse createFromParcel(Parcel in) {
                return new ArtObjectResponse(in);
            }

            public ArtObjectResponse[] newArray(int size) {
                return (new ArtObjectResponse[size]);
            }
        };

        private ArtObjectResponse(Parcel in) {
            mCount = in.readInt();
            mCountFacets = ((CountFacets) in.readValue((CountFacets.class.getClassLoader())));
            in.readList(mArtObjects, (ArtObject.class.getClassLoader()));
            in.readList(mFacets, (Facet.class.getClassLoader()));
        }

    public ArtObjectResponse(Integer count, CountFacets countFacets, ArrayList<ArtObject> artObjects, List<Facet> facets) {
            super();
            mCount = count;
            mCountFacets = countFacets;
            mArtObjects = artObjects;
            mFacets = facets;
        }

        public Integer getCount() {
            return mCount;
        }
        public CountFacets getCountFacets() {
            return mCountFacets;
        }

    public ArrayList<ArtObject> getArtObjects() {
            return mArtObjects;
        }
        public List<Facet> getFacets() {
            return mFacets;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(mCount);
            out.writeValue(mCountFacets);
            out.writeList(mArtObjects);
            out.writeList(mFacets);
        }

        public int describeContents() {
            return 0;
        }

    }




