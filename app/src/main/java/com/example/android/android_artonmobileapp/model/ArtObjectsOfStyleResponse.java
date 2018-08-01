package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ArtObjectsOfStyleResponse implements Parcelable {

    public final static Parcelable.Creator<ArtObjectsOfStyleResponse> CREATOR = new Creator<ArtObjectsOfStyleResponse>() {


        public ArtObjectsOfStyleResponse createFromParcel(Parcel in) {
            return new ArtObjectsOfStyleResponse(in);
        }

        public ArtObjectsOfStyleResponse[] newArray(int size) {
            return (new ArtObjectsOfStyleResponse[size]);
        }

    };
    @SerializedName("elapsedMilliseconds")
    private Integer elapsedMilliseconds;
    @SerializedName("contentPage")
    private StyleDetails contentPage;
    @SerializedName("similarPages")
    private Object similarPages;

    protected ArtObjectsOfStyleResponse(Parcel in) {
        this.elapsedMilliseconds = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.contentPage = ((StyleDetails) in.readValue((StyleDetails.class.getClassLoader())));
        this.similarPages = in.readValue((Object.class.getClassLoader()));
    }

    public ArtObjectsOfStyleResponse() {
    }

    public Integer getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(Integer elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    public ArtObjectsOfStyleResponse withElapsedMilliseconds(Integer elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
        return this;
    }

    public StyleDetails getArtObjectsOfStyle() {
        return contentPage;
    }

    public void setContentPage(StyleDetails contentPage) {
        this.contentPage = contentPage;
    }

    public ArtObjectsOfStyleResponse withContentPage(StyleDetails contentPage) {
        this.contentPage = contentPage;
        return this;
    }

    public Object getSimilarPages() {
        return similarPages;
    }

    public void setSimilarPages(Object similarPages) {
        this.similarPages = similarPages;
    }

    public ArtObjectsOfStyleResponse withSimilarPages(Object similarPages) {
        this.similarPages = similarPages;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(elapsedMilliseconds);
        dest.writeValue(contentPage);
        dest.writeValue(similarPages);
    }

    public int describeContents() {
        return 0;
    }

}