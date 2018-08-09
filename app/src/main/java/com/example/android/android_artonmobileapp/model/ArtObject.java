package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ArtObject implements Parcelable {

    public final static Parcelable.Creator<ArtObject> CREATOR = new Creator<ArtObject>() {
        public ArtObject createFromParcel(Parcel in) {
            return new ArtObject(in);
        }

        public ArtObject[] newArray(int size) {
            return (new ArtObject[size]);
        }
    };
    @SerializedName("objectNumber")
    private String mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("principalOrFirstMaker")
    private String mPrincipalOrFirstMaker;
    @SerializedName("webImage")
    private WebImage mWebImage;
private String mImage;
    private ArtObject(Parcel in) {
        mId = in.readString();
        mTitle = in.readString();
        mPrincipalOrFirstMaker = in.readString();
        mWebImage = (WebImage) in.readValue(WebImage.class.getClassLoader());
        mImage = in.readString();
    }

    public ArtObject(){}

    public ArtObject(String id, String title, String principalOrFirstMaker, WebImage webImage, String image) {
        super();
        mId = id;
        mTitle = title;
        mPrincipalOrFirstMaker = principalOrFirstMaker;
        mWebImage = webImage;
        mImage = image;
    }


    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }

    public void setPrincipalOrFirstMaker(String principalOrFirstMaker) {
        mPrincipalOrFirstMaker = principalOrFirstMaker;
    }


    public WebImage getWebImage() {
        return mWebImage;
    }

    public String getImage() {
        return mImage;
    }


  public void setImage(String image) {mImage = image;}


    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mId);
        out.writeString(mTitle);
        out.writeString(mPrincipalOrFirstMaker);
        out.writeValue(mWebImage);
        out.writeString(mImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
