package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtObjectResponse implements Parcelable {

        @SerializedName("elapsedMilliseconds")
        private Integer mElapsedMilliseconds;
        @SerializedName("count")
        private Integer mCount;
        @SerializedName("countFacets")
        private CountFacets mCountFacets;
        @SerializedName("artObjects")
        private List<ArtObject> mArtObjects = null;
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
            mElapsedMilliseconds = in.readInt();
            mCount = in.readInt();
            mCountFacets = ((CountFacets) in.readValue((CountFacets.class.getClassLoader())));
            in.readList(mArtObjects, (ArtObject.class.getClassLoader()));
            in.readList(mFacets, (Facet.class.getClassLoader()));
        }

        public ArtObjectResponse(Integer elapsedMilliseconds, Integer count, CountFacets countFacets, List<ArtObject> artObjects, List<Facet> facets) {
            super();
            mElapsedMilliseconds = elapsedMilliseconds;
            mCount = count;
            mCountFacets = countFacets;
            mArtObjects = artObjects;
            mFacets = facets;
        }

        public Integer getElapsedMilliseconds() {
            return mElapsedMilliseconds;
        }
        public Integer getCount() {
            return mCount;
        }
        public CountFacets getCountFacets() {
            return mCountFacets;
        }
        public List<ArtObject> getArtObjects() {
            return mArtObjects;
        }
        public List<Facet> getFacets() {
            return mFacets;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(mElapsedMilliseconds);
            out.writeInt(mCount);
            out.writeValue(mCountFacets);
            out.writeList(mArtObjects);
            out.writeList(mFacets);
        }

        public int describeContents() {
            return 0;
        }

    }




