package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AdlibOverrides implements Parcelable {

    public final static Parcelable.Creator<AdlibOverrides> CREATOR = new Creator<AdlibOverrides>() {


        public AdlibOverrides createFromParcel(Parcel in) {
            return new AdlibOverrides(in);
        }

        public AdlibOverrides[] newArray(int size) {
            return (new AdlibOverrides[size]);
        }

    };
    @SerializedName("titel")
    private Object titel;
    @SerializedName("maker")
    private Object maker;
    @SerializedName("etiketText")
    private Object etiketText;

    protected AdlibOverrides(Parcel in) {
        this.titel = in.readValue((Object.class.getClassLoader()));
        this.maker = in.readValue((Object.class.getClassLoader()));
        this.etiketText = in.readValue((Object.class.getClassLoader()));
    }

    public AdlibOverrides() {
    }

    public Object getTitel() {
        return titel;
    }

    public void setTitel(Object titel) {
        this.titel = titel;
    }

    public Object getMaker() {
        return maker;
    }

    public void setMaker(Object maker) {
        this.maker = maker;
    }

    public Object getEtiketText() {
        return etiketText;
    }

    public void setEtiketText(Object etiketText) {
        this.etiketText = etiketText;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(titel);
        dest.writeValue(maker);
        dest.writeValue(etiketText);
    }

    public int describeContents() {
        return 0;
    }

}
