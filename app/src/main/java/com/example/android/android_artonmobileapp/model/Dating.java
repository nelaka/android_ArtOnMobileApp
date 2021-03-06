package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dating implements Parcelable
{

    @SerializedName("presentingDate")
    @Expose
    private String presentingDate;
    @SerializedName("sortingDate")
    @Expose
    private int sortingDate;
    @SerializedName("period")
    @Expose
    private int period;
    @SerializedName("yearEarly")
    @Expose
    private int yearEarly;
    @SerializedName("yearLate")
    @Expose
    private int yearLate;
    public final static Parcelable.Creator<Dating> CREATOR = new Creator<Dating>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dating createFromParcel(Parcel in) {
            return new Dating(in);
        }

        public Dating[] newArray(int size) {
            return (new Dating[size]);
        }

    }
            ;

    Dating(Parcel in) {
        this.presentingDate = ((String) in.readValue((String.class.getClassLoader())));
        this.sortingDate = ((int) in.readValue((int.class.getClassLoader())));
        this.period = ((int) in.readValue((int.class.getClassLoader())));
        this.yearEarly = ((int) in.readValue((int.class.getClassLoader())));
        this.yearLate = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Dating() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(presentingDate);
        dest.writeValue(sortingDate);
        dest.writeValue(period);
        dest.writeValue(yearEarly);
        dest.writeValue(yearLate);
    }

    public int describeContents() {
        return 0;
    }

}
