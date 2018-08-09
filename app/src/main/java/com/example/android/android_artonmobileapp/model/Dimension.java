package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimension implements Parcelable
{

    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("part")
    @Expose
    private Object part;
    @SerializedName("value")
    @Expose
    private String value;
    public final static Parcelable.Creator<Dimension> CREATOR = new Creator<Dimension>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dimension createFromParcel(Parcel in) {
            return new Dimension(in);
        }

        public Dimension[] newArray(int size) {
            return (new Dimension[size]);
        }

    }
            ;

    Dimension(Parcel in) {
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.part = in.readValue((Object.class.getClassLoader()));
        this.value = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Dimension() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(unit);
        dest.writeValue(type);
        dest.writeValue(part);
        dest.writeValue(value);
    }

    public int describeContents() {
        return 0;
    }

}
