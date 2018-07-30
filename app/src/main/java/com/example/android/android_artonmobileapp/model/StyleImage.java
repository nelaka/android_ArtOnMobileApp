package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class StyleImage implements Parcelable {

    public final static Parcelable.Creator<StyleImage> CREATOR = new Creator<StyleImage>() {
        public StyleImage createFromParcel(Parcel in) {
            return new StyleImage(in);
        }

        public StyleImage[] newArray(int size) {
            return (new StyleImage[size]);
        }
    };
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    protected StyleImage(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
    }

    public StyleImage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(url);
    }

    public int describeContents() {
        return 0;
    }

}
