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

        protected ArtObjectPage(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.similarPages, (java.lang.Object.class.getClassLoader()));
            this.lang = ((String) in.readValue((String.class.getClassLoader())));
            this.objectNumber = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.tags, (java.lang.Object.class.getClassLoader()));
            this.plaqueDescription = ((String) in.readValue((String.class.getClassLoader())));
            this.audioFile1 = ((Object) in.readValue((Object.class.getClassLoader())));
            this.audioFileLabel1 = ((Object) in.readValue((Object.class.getClassLoader())));
            this.audioFileLabel2 = ((Object) in.readValue((Object.class.getClassLoader())));
            this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
            this.updatedOn = ((String) in.readValue((String.class.getClassLoader())));
            this.adlibOverrides = ((AdlibOverrides) in.readValue((AdlibOverrides.class.getClassLoader())));
        }

        public ArtObjectPage() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Object> getSimilarPages() {
            return similarPages;
        }

        public void setSimilarPages(List<Object> similarPages) {
            this.similarPages = similarPages;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getObjectNumber() {
            return objectNumber;
        }

        public void setObjectNumber(String objectNumber) {
            this.objectNumber = objectNumber;
        }

        public List<Object> getTags() {
            return tags;
        }

        public void setTags(List<Object> tags) {
            this.tags = tags;
        }

        public String getPlaqueDescription() {
            return plaqueDescription;
        }

        public void setPlaqueDescription(String plaqueDescription) {
            this.plaqueDescription = plaqueDescription;
        }

        public Object getAudioFile1() {
            return audioFile1;
        }

        public void setAudioFile1(Object audioFile1) {
            this.audioFile1 = audioFile1;
        }

        public Object getAudioFileLabel1() {
            return audioFileLabel1;
        }

        public void setAudioFileLabel1(Object audioFileLabel1) {
            this.audioFileLabel1 = audioFileLabel1;
        }

        public Object getAudioFileLabel2() {
            return audioFileLabel2;
        }

        public void setAudioFileLabel2(Object audioFileLabel2) {
            this.audioFileLabel2 = audioFileLabel2;
        }

        public String getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(String createdOn) {
            this.createdOn = createdOn;
        }

        public String getUpdatedOn() {
            return updatedOn;
        }

        public void setUpdatedOn(String updatedOn) {
            this.updatedOn = updatedOn;
        }

        public AdlibOverrides getAdlibOverrides() {
            return adlibOverrides;
        }

        public void setAdlibOverrides(AdlibOverrides adlibOverrides) {
            this.adlibOverrides = adlibOverrides;
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
