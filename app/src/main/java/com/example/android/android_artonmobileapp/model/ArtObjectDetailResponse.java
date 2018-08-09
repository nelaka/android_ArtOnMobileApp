package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ArtObjectDetailResponse implements Parcelable {

    @SerializedName("artObject")
    private ArtObjectDetail mArtObject;
    @SerializedName("artObjectPage")
    private ArtObjectPage mArtObjectPage;
    public final static Parcelable.Creator<ArtObjectDetailResponse> CREATOR = new Creator<ArtObjectDetailResponse>() {

        public ArtObjectDetailResponse createFromParcel(Parcel in) {
            return new ArtObjectDetailResponse(in);
        }

        public ArtObjectDetailResponse[] newArray(int size) {
            return (new ArtObjectDetailResponse[size]);
        }
    };

    private ArtObjectDetailResponse(Parcel in) {
        mArtObject = ((ArtObjectDetail) in.readValue((ArtObjectDetail.class.getClassLoader())));
        mArtObjectPage = ((ArtObjectPage) in.readValue((ArtObjectPage.class.getClassLoader())));
    }

    public ArtObjectDetail getArtObject() {
        return mArtObject;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeValue(mArtObject);
        out.writeValue(mArtObjectPage);
    }

    public int describeContents() {
        return 0;
    }

}


