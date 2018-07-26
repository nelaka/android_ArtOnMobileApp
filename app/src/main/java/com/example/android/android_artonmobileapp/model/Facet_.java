package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Facet_ implements Parcelable {

        @SerializedName("key")
        private String mKey;
        @SerializedName("value")
        private Integer mValue;
        public final static Parcelable.Creator<Facet_> CREATOR = new Creator<Facet_>() {
            public Facet_ createFromParcel(Parcel in) {
                return new Facet_(in);
            }

            public Facet_[] newArray(int size) {
                return (new Facet_[size]);
            }
        };

        private Facet_(Parcel in) {
            mKey = in.readString();
            mValue = in.readInt();
        }

        public Facet_(String key, Integer value) {
            super();
            mKey = key;
            mValue = value;
        }

        public String getKey() {
            return mKey;
        }

        public Integer getValue() {
            return mValue;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(mKey);
            out.writeInt(mValue);
        }

        public int describeContents() {
            return 0;
        }

    }