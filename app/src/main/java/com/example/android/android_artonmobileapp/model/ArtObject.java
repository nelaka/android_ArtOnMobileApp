package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ArtObject implements Parcelable {

        @SerializedName("objectNumber")
        private String mId;
        @SerializedName("title")
        private String mTitle;
    @SerializedName("principalOrFirstMaker")
        private String mPrincipalOrFirstMaker;
        @SerializedName("longTitle")
        private String mLongTitle;
        @SerializedName("webImage")
        private WebImage mWebImage;
    private String mImage;
        public final static Parcelable.Creator<ArtObject> CREATOR = new Creator<ArtObject>() {
            public ArtObject createFromParcel(Parcel in) { return new ArtObject(in); }
            public ArtObject[] newArray(int size) { return (new ArtObject[size]); }
        };

        private ArtObject(Parcel in) {
            mId = in.readString();
            mTitle = in.readString();
            mPrincipalOrFirstMaker = in.readString();
            mLongTitle = in.readString();
            mWebImage = (WebImage) in.readValue(WebImage.class.getClassLoader());

        }


    public ArtObject(String id, String title, String principalOrFirstMaker, String longTitle, String webImage) {
            super();
            mId = id;
            mTitle = title;
        mPrincipalOrFirstMaker = principalOrFirstMaker;
            mLongTitle = longTitle;
        mImage = webImage;
    }


        public String getId() {
            return mId;
        }
        public String getTitle() {
            return mTitle;
        }
        public String getPrincipalOrFirstMaker() {
            return mPrincipalOrFirstMaker;
        }
        public String getLongTitle() {
            return mLongTitle;
        }

    public String getWebImage() {
        return mWebImage.getUrl();
        }



        @Override
        public void writeToParcel(Parcel out, int flags) {
            out.writeString(mId);
            out.writeString(mTitle);
            out.writeString(mPrincipalOrFirstMaker);
            out.writeString(mLongTitle);
            out.writeValue(mWebImage);
        }

        @Override
        public int describeContents() {
            return 0;
        }
    }
