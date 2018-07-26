package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable {

        @SerializedName("self")
        private String mSelf;
        @SerializedName("web")
        private String mWeb;

        public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {

            public Links createFromParcel(Parcel in) {
                return new Links(in);
            }
            public Links[] newArray(int size) {
                return (new Links[size]);
            }
        };

        private Links(Parcel in) {
            mSelf = in.readString();
            mWeb = in.readString();   }

        public Links(String self, String web) {
            super();
            mSelf = self;
            mWeb = web;
        }

        public String getSelf() {
            return mSelf;
        }
        public String getWeb() {
            return mWeb;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(mSelf);
            out.writeString(mWeb);
        }

        public int describeContents() {
            return 0;
        }

    }
