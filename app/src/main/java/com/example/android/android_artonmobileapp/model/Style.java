package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Style implements Parcelable {

    public final static Parcelable.Creator<Style> CREATOR = new Creator<Style>() {
        public Style createFromParcel(Parcel in) {
            return new Style(in);
        }

        public Style[] newArray(int size) {
            return (new Style[size]);
        }
    };
    @SerializedName("title")
    private String mTitle;
    @SerializedName("image")
    private StyleImage image;

    private Style(Parcel in) {
        mTitle = in.readString();
        this.image = ((StyleImage) in.readValue((StyleImage.class.getClassLoader())));
    }

    public Style() {
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public StyleImage getImage() {
        return image;
    }

    public void setImage(StyleImage image) {
        this.image = image;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeValue(image);
    }

    public int describeContents() {
        return 0;
    }

}