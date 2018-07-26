package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimension implements Parcelable
    {

        @SerializedName("unit")
        private String unit;
        @SerializedName("type")
        private String type;
        @SerializedName("part")
        private Object part;
        @SerializedName("value")
        private String value;
        public final static Parcelable.Creator<Dimension> CREATOR = new Creator<Dimension>() {

            public Dimension createFromParcel(Parcel in) {
                return new Dimension(in);
            }

            public Dimension[] newArray(int size) {
                return (new Dimension[size]);
            }

        };

        private Dimension(Parcel in) {
            this.unit = ((String) in.readValue((String.class.getClassLoader())));
            this.type = ((String) in.readValue((String.class.getClassLoader())));
            this.part = ((Object) in.readValue((Object.class.getClassLoader())));
            this.value = ((String) in.readValue((String.class.getClassLoader())));
        }


        public Dimension(String unit, String type, Object part, String value) {
            super();
            this.unit = unit;
            this.type = type;
            this.part = part;
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getPart() {
            return part;
        }

        public void setPart(Object part) {
            this.part = part;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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

