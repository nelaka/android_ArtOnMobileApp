package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable
    {

        @SerializedName("search")
        @Expose
        private String search;
        public final static Parcelable.Creator<com.example.android.android_artonmobileapp.model.Links> CREATOR = new Creator<com.example.android.android_artonmobileapp.model.Links>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public com.example.android.android_artonmobileapp.model.Links createFromParcel(Parcel in) {
                return new com.example.android.android_artonmobileapp.model.Links(in);
            }

            public com.example.android.android_artonmobileapp.model.Links[] newArray(int size) {
                return (new com.example.android.android_artonmobileapp.model.Links[size]);
            }

        }
                ;

        private Links(Parcel in) {
            this.search = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Links() {
        }

        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(search);
        }

        public int describeContents() {
            return 0;
        }

    }