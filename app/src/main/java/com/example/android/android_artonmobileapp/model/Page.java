package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Page implements Parcelable {

    public final static Parcelable.Creator<Page> CREATOR = new Creator<Page>() {
        public Page createFromParcel(Parcel in) {
            return new Page(in);
        }

        public Page[] newArray(int size) {
            return (new Page[size]);
        }

    };
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    private Page(Parcel in) {
        this.title = in.readString();
        this.url = in.readString();
    }

    public Page() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url);
    }

    public int describeContents() {
        return 0;
    }
}
