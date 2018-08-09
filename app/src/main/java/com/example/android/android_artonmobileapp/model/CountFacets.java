package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CountFacets implements Parcelable {

        @SerializedName("hasimage")
        private Integer mHasImage;
        @SerializedName("ondisplay")
        private Integer mOnDisplay;
        public final static Parcelable.Creator<CountFacets> CREATOR = new Creator<CountFacets>() {
            public CountFacets createFromParcel(Parcel in) {
                return new CountFacets(in);
            }

            public CountFacets[] newArray(int size) {
                return (new CountFacets[size]);
            }
        };

        private CountFacets(Parcel in) {
            mHasImage = in.readInt();
            mOnDisplay = in.readInt();
        }

    public void writeToParcel(Parcel out, int flags) {
            out.writeInt(mHasImage);
            out.writeInt(mOnDisplay);
        }

        public int describeContents() {
            return 0;
        }

    }