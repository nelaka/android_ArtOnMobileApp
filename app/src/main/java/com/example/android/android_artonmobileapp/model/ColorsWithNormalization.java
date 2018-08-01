package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ColorsWithNormalization implements Parcelable
    {

        @SerializedName("originalHex")
        @Expose
        private String originalHex;
        @SerializedName("normalizedHex")
        @Expose
        private String normalizedHex;
        public final static Parcelable.Creator<com.example.android.android_artonmobileapp.model.ColorsWithNormalization> CREATOR = new Parcelable.Creator<ColorsWithNormalization>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public com.example.android.android_artonmobileapp.model.ColorsWithNormalization createFromParcel(Parcel in) {
                return new com.example.android.android_artonmobileapp.model.ColorsWithNormalization(in);
            }

            public com.example.android.android_artonmobileapp.model.ColorsWithNormalization[] newArray(int size) {
                return (new com.example.android.android_artonmobileapp.model.ColorsWithNormalization[size]);
            }

        }
                ;

        protected ColorsWithNormalization(Parcel in) {
            this.originalHex = ((String) in.readValue((String.class.getClassLoader())));
            this.normalizedHex = ((String) in.readValue((String.class.getClassLoader())));
        }

        public ColorsWithNormalization() {
        }

        public String getOriginalHex() {
            return originalHex;
        }

        public void setOriginalHex(String originalHex) {
            this.originalHex = originalHex;
        }

        public String getNormalizedHex() {
            return normalizedHex;
        }

        public void setNormalizedHex(String normalizedHex) {
            this.normalizedHex = normalizedHex;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(originalHex);
            dest.writeValue(normalizedHex);
        }

        public int describeContents() {
            return 0;
        }

    }
