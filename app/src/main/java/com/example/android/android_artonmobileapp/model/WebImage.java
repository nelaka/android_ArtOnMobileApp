package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebImage implements Parcelable
    {

        @SerializedName("guid")
        @Expose
        private String guid;
        @SerializedName("offsetPercentageX")
        @Expose
        private int offsetPercentageX;
        @SerializedName("offsetPercentageY")
        @Expose
        private int offsetPercentageY;
        @SerializedName("width")
        @Expose
        private int width;
        @SerializedName("height")
        @Expose
        private int height;
        @SerializedName("url")
        @Expose
        private String url;
        public final static Parcelable.Creator<com.example.android.android_artonmobileapp.model.WebImage> CREATOR = new Creator<com.example.android.android_artonmobileapp.model.WebImage>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public com.example.android.android_artonmobileapp.model.WebImage createFromParcel(Parcel in) {
                return new com.example.android.android_artonmobileapp.model.WebImage(in);
            }

            public com.example.android.android_artonmobileapp.model.WebImage[] newArray(int size) {
                return (new com.example.android.android_artonmobileapp.model.WebImage[size]);
            }

        }
                ;

        WebImage(Parcel in) {
            this.guid = ((String) in.readValue((String.class.getClassLoader())));
            this.offsetPercentageX = ((int) in.readValue((int.class.getClassLoader())));
            this.offsetPercentageY = ((int) in.readValue((int.class.getClassLoader())));
            this.width = ((int) in.readValue((int.class.getClassLoader())));
            this.height = ((int) in.readValue((int.class.getClassLoader())));
            this.url = ((String) in.readValue((String.class.getClassLoader())));
        }

        public WebImage() {
        }

        public String getUrl() {
            return url;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(guid);
            dest.writeValue(offsetPercentageX);
            dest.writeValue(offsetPercentageY);
            dest.writeValue(width);
            dest.writeValue(height);
            dest.writeValue(url);
        }

        public int describeContents() {
            return 0;
        }

    }