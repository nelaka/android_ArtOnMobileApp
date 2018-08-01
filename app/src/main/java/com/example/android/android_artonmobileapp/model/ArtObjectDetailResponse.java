package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtObjectDetailResponse implements Parcelable
    {

        @SerializedName("elapsedMilliseconds")
        @Expose
        private int elapsedMilliseconds;
        @SerializedName("artObject")
        @Expose
        private ArtObjectDetail artObject;
        @SerializedName("artObjectPage")
        @Expose
        private ArtObjectPage artObjectPage;
        public final static Parcelable.Creator<ArtObjectDetailResponse> CREATOR = new Creator<ArtObjectDetailResponse>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public ArtObjectDetailResponse createFromParcel(Parcel in) {
                return new ArtObjectDetailResponse(in);
            }

            public ArtObjectDetailResponse[] newArray(int size) {
                return (new ArtObjectDetailResponse[size]);
            }

        }
                ;

        protected ArtObjectDetailResponse(Parcel in) {
            this.elapsedMilliseconds = ((int) in.readValue((int.class.getClassLoader())));
            this.artObject = ((ArtObjectDetail) in.readValue((ArtObjectDetail.class.getClassLoader())));
            this.artObjectPage = ((ArtObjectPage) in.readValue((ArtObjectPage.class.getClassLoader())));
        }

        public ArtObjectDetailResponse() {
        }

        public int getElapsedMilliseconds() {
            return elapsedMilliseconds;
        }

        public void setElapsedMilliseconds(int elapsedMilliseconds) {
            this.elapsedMilliseconds = elapsedMilliseconds;
        }

        public ArtObjectDetail getArtObject() {
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
            dest.writeValue(elapsedMilliseconds);
            dest.writeValue(artObject);
            dest.writeValue(artObjectPage);
        }

        public int describeContents() {
            return 0;
        }

    }


