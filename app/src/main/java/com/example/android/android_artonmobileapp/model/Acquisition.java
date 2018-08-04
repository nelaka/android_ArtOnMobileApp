package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Acquisition implements Parcelable
{

    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("creditLine")
    @Expose
    private String creditLine;
    public final static Parcelable.Creator<Acquisition> CREATOR = new Creator<Acquisition>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Acquisition createFromParcel(Parcel in) {
            return new Acquisition(in);
        }

        public Acquisition[] newArray(int size) {
            return (new Acquisition[size]);
        }

    }
            ;

    private Acquisition(Parcel in) {
        this.method = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.creditLine = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Acquisition() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(method);
        dest.writeValue(date);
        dest.writeValue(creditLine);
    }

    public int describeContents() {
        return 0;
    }

}

