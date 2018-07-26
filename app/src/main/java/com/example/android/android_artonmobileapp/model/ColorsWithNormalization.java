package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ColorsWithNormalization implements Parcelable {

        @SerializedName("originalHex")
        private String mOriginalHex;
        @SerializedName("normalizedHex")
        private String mNormalizedHex;
        public final static Parcelable.Creator<ColorsWithNormalization> CREATOR = new Creator<ColorsWithNormalization>() {


           public ColorsWithNormalization createFromParcel(Parcel in) {
                return new ColorsWithNormalization(in);
            }

            public ColorsWithNormalization[] newArray(int size) {
                return (new ColorsWithNormalization[size]);
            }
        };

        private ColorsWithNormalization(Parcel in) {
            mOriginalHex = in.readString();
            mNormalizedHex = in.readString();
        }

        public ColorsWithNormalization(String originalHex, String normalizedHex) {
            super();
            mOriginalHex = originalHex;
            mNormalizedHex = normalizedHex;
        }

        public String getOriginalHex() {
            return mOriginalHex;
        }

        public void setOriginalHex(String originalHex) {
            mOriginalHex = originalHex;
        }

        public String getNormalizedHex() {
            return mNormalizedHex;
        }

        public void setNormalizedHex(String normalizedHex) {
            mNormalizedHex = normalizedHex;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(mOriginalHex);
            out.writeString(mNormalizedHex);
        }

        public int describeContents() {
            return 0;
        }

    }


