package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;


import com.google.gson.annotations.SerializedName;

public class Dating implements Parcelable
    {

        @SerializedName("presentingDate")
        private String presentingDate;
        @SerializedName("sortingDate")
        private Integer sortingDate;
        @SerializedName("period")
        private Integer period;
        @SerializedName("yearEarly")
        private Integer yearEarly;
        @SerializedName("yearLate")
        private Integer yearLate;
        public final static Parcelable.Creator<Dating> CREATOR = new Creator<Dating>() {


            public Dating createFromParcel(Parcel in) {
                return new Dating(in);
            }

            public Dating[] newArray(int size) {
                return (new Dating[size]);
            }
        };

        private Dating(Parcel in) {
            this.presentingDate = ((String) in.readValue((String.class.getClassLoader())));
            this.sortingDate = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.period = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.yearEarly = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.yearLate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Dating(String presentingDate, Integer sortingDate, Integer period, Integer yearEarly, Integer yearLate) {
            super();
            this.presentingDate = presentingDate;
            this.sortingDate = sortingDate;
            this.period = period;
            this.yearEarly = yearEarly;
            this.yearLate = yearLate;
        }

        public String getPresentingDate() {
            return presentingDate;
        }

        public void setPresentingDate(String presentingDate) {
            this.presentingDate = presentingDate;
        }

        public Integer getSortingDate() {
            return sortingDate;
        }

        public void setSortingDate(Integer sortingDate) {
            this.sortingDate = sortingDate;
        }

        public Integer getPeriod() {
            return period;
        }

        public void setPeriod(Integer period) {
            this.period = period;
        }

        public Integer getYearEarly() {
            return yearEarly;
        }

        public void setYearEarly(Integer yearEarly) {
            this.yearEarly = yearEarly;
        }

        public Integer getYearLate() {
            return yearLate;
        }

        public void setYearLate(Integer yearLate) {
            this.yearLate = yearLate;
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

