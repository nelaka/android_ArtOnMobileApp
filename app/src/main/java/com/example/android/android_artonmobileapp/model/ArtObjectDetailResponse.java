package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ArtObjectDetailResponse implements Parcelable {
    public final static Parcelable.Creator<ArtObjectDetailResponse> CREATOR = new Creator<ArtObjectDetailResponse>() {


        @SuppressWarnings({"unchecked"})
        public ArtObjectDetailResponse createFromParcel(Parcel in) {
            return new ArtObjectDetailResponse(in);
        }

        public ArtObjectDetailResponse[] newArray(int size) {
            return (new ArtObjectDetailResponse[size]);
        }
    };
    @SerializedName("artObject")
    private ArtObjectDetail artObject;
    @SerializedName("artObjectPage")
    private ArtObjectPage artObjectPage;

    private ArtObjectDetailResponse(Parcel in) {
        this.artObject = ((ArtObjectDetail) in.readValue((ArtObject.class.getClassLoader())));
        this.artObjectPage = ((ArtObjectPage) in.readValue((ArtObjectPage.class.getClassLoader())));
    }

    public ArtObjectDetailResponse() {
    }

    public ArtObjectDetail getArtObjectDetail() {
        return artObject;
    }

    public void setArtObject(ArtObjectDetail artObject) {
        this.artObject = artObject;
    }

    public ArtObjectPage getArtObjectPage() {
        return artObjectPage;
    }

    public void setArtObjectPage(ArtObjectPage artObjectPage) {
        this.artObjectPage = artObjectPage;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(artObject);
        dest.writeValue(artObjectPage);
    }

    public int describeContents() {
        return 0;
    }

}