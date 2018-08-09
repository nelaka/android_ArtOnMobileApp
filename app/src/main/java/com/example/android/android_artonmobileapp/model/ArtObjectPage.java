package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtObjectPage implements Parcelable
    {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("similarPages")
        @Expose
        private List<Object> similarPages = null;
        @SerializedName("lang")
        @Expose
        private String lang;
        @SerializedName("objectNumber")
        @Expose
        private String objectNumber;
        @SerializedName("tags")
        @Expose
        private List<Object> tags = null;
        @SerializedName("plaqueDescription")
        @Expose
        private String plaqueDescription;
        @SerializedName("audioFile1")
        @Expose
        private Object audioFile1;
        @SerializedName("audioFileLabel1")
        @Expose
        private Object audioFileLabel1;
        @SerializedName("audioFileLabel2")
        @Expose
        private Object audioFileLabel2;
        @SerializedName("createdOn")
        @Expose
        private String createdOn;
        @SerializedName("updatedOn")
        @Expose
        private String updatedOn;
        @SerializedName("adlibOverrides")
        @Expose
        private AdlibOverrides adlibOverrides;
        public final static Parcelable.Creator<com.example.android.android_artonmobileapp.model.ArtObjectPage> CREATOR = new Creator<com.example.android.android_artonmobileapp.model.ArtObjectPage>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public com.example.android.android_artonmobileapp.model.ArtObjectPage createFromParcel(Parcel in) {
                return new com.example.android.android_artonmobileapp.model.ArtObjectPage(in);
            }

            public com.example.android.android_artonmobileapp.model.ArtObjectPage[] newArray(int size) {
                return (new com.example.android.android_artonmobileapp.model.ArtObjectPage[size]);
            }

        }
                ;

        ArtObjectPage(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.similarPages, (java.lang.Object.class.getClassLoader()));
            this.lang = ((String) in.readValue((String.class.getClassLoader())));
            this.objectNumber = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.tags, (java.lang.Object.class.getClassLoader()));
            this.plaqueDescription = ((String) in.readValue((String.class.getClassLoader())));
            this.audioFile1 = in.readValue((Object.class.getClassLoader()));
            this.audioFileLabel1 = in.readValue((Object.class.getClassLoader()));
            this.audioFileLabel2 = in.readValue((Object.class.getClassLoader()));
            this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
            this.updatedOn = ((String) in.readValue((String.class.getClassLoader())));
            this.adlibOverrides = ((AdlibOverrides) in.readValue((AdlibOverrides.class.getClassLoader())));
        }

        public ArtObjectPage() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeList(similarPages);
            dest.writeValue(lang);
            dest.writeValue(objectNumber);
            dest.writeList(tags);
            dest.writeValue(plaqueDescription);
            dest.writeValue(audioFile1);
            dest.writeValue(audioFileLabel1);
            dest.writeValue(audioFileLabel2);
            dest.writeValue(createdOn);
            dest.writeValue(updatedOn);
            dest.writeValue(adlibOverrides);
        }

        public int describeContents() {
            return 0;
        }

    }
