package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class StylesResponse implements Parcelable {

    public final static Parcelable.Creator<StylesResponse> CREATOR = new Creator<StylesResponse>() {
        public StylesResponse createFromParcel(Parcel in) {
            return new StylesResponse(in);
        }

        public StylesResponse[] newArray(int size) {
            return (new StylesResponse[size]);
        }
    };
    @SerializedName("elapsedMilliseconds")
    private Integer elapsedMilliseconds;
    @SerializedName("contentPage")
    private ContentPage contentPage;
    @SerializedName("similarPages")
    private Object similarPages;

    private StylesResponse(Parcel in) {
        this.elapsedMilliseconds = in.readInt();
        this.contentPage = ((ContentPage) in.readValue((ContentPage.class.getClassLoader())));
        this.similarPages = in.readValue((Object.class.getClassLoader()));
    }

    public StylesResponse() {
    }

    public Integer getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(Integer elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    public ContentPage getContentPage() {
        return contentPage;
    }

    public void setContentPage(ContentPage contentPage) {
        this.contentPage = contentPage;
    }

    public Object getSimilarPages() {
        return similarPages;
    }

    public void setSimilarPages(Object similarPages) {
        this.similarPages = similarPages;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(elapsedMilliseconds);
        dest.writeValue(contentPage);
        dest.writeValue(similarPages);
    }

    public int describeContents() {
        return 0;
    }

}