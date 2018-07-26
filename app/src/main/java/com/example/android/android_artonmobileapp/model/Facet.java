package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Facet implements Parcelable {

        public final static Parcelable.Creator<Facet> CREATOR = new Creator<Facet>() {
            public Facet createFromParcel(Parcel in) {
                return new Facet(in);
            }

            public Facet[] newArray(int size) {
                return (new Facet[size]);
            }
        };
        @SerializedName("facets")
        private List<Facet_> mFacets = null;
        @SerializedName("name")
        private String mName;
        @SerializedName("otherTerms")
        private Integer mOtherTerms;
        @SerializedName("prettyName")
        private Integer mPrettyName;

        private Facet(Parcel in) {
            in.readList(mFacets, Facet_.class.getClassLoader());
            mName = in.readString();
            mOtherTerms = in.readInt();
            mPrettyName = in.readInt();
        }

        public Facet(List<Facet_> facets, String name, Integer otherTerms, Integer prettyName) {
            super();
            mFacets = facets;
            mName = name;
            mOtherTerms = otherTerms;
            mPrettyName = prettyName;
        }

        public List<Facet_> getFacets() {
            return mFacets;
        }

        public String getName() {
            return mName;
        }

        public Integer getOtherTerms() {
            return mOtherTerms;
        }

        public Integer getPrettyName() {
            return mPrettyName;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeList(mFacets);
            out.writeString(mName);
            out.writeInt(mOtherTerms);
            out.writeInt(mPrettyName);
        }

        public int describeContents() {
            return 0;
        }

    }