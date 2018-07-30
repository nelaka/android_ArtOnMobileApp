package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StyleDetails implements Parcelable {

    public final static Parcelable.Creator<StyleDetails> CREATOR = new Creator<StyleDetails>() {


        @SuppressWarnings({"unchecked"})
        public StyleDetails createFromParcel(Parcel in) {
            return new StyleDetails(in);
        }

        public StyleDetails[] newArray(int size) {
            return (new StyleDetails[size]);
        }

    };
    @SerializedName("artObjectSet")
    private List<String> artObjectSet = null;
    @SerializedName("headerImage")
    private String headerImage;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private Object description;

    protected StyleDetails(Parcel in) {
        in.readList(this.artObjectSet, (java.lang.String.class.getClassLoader()));
        this.headerImage = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
        this.title = in.readString();
        this.description = in.readValue((Object.class.getClassLoader()));
    }

    public StyleDetails() {
    }

    public List<String> getArtObjectSet() {
        return artObjectSet;
    }

    public void setArtObjectSet(List<String> artObjectSet) {
        this.artObjectSet = artObjectSet;
    }

    public StyleDetails withArtObjectSet(List<String> artObjectSet) {
        this.artObjectSet = artObjectSet;
        return this;
    }


    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public StyleDetails withHeaderImage(String headerImage) {
        this.headerImage = headerImage;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public StyleDetails withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StyleDetails withTitle(String title) {
        this.title = title;
        return this;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public StyleDetails withDescription(Object description) {
        this.description = description;
        return this;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(artObjectSet);
        dest.writeValue(headerImage);
        dest.writeValue(thumbnail);
        dest.writeString(title);
        dest.writeValue(description);

    }

    public int describeContents() {
        return 0;
    }

}