package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Label implements Parcelable
    {

        @SerializedName("title")
        private String title;
        @SerializedName("makerLine")
        private String makerLine;
        @SerializedName("description")
        private Object description;
        @SerializedName("notes")
        private String notes;
        @SerializedName("date")
        private String date;
        public final static Parcelable.Creator<Label> CREATOR = new Creator<Label>() {



            public Label createFromParcel(Parcel in) {
                return new Label(in);
            }

            public Label[] newArray(int size) {
                return (new Label[size]);
            }

        };

        private Label(Parcel in) {
            this.title = ((String) in.readValue((String.class.getClassLoader())));
            this.makerLine = ((String) in.readValue((String.class.getClassLoader())));
            this.description = ((Object) in.readValue((Object.class.getClassLoader())));
            this.notes = ((String) in.readValue((String.class.getClassLoader())));
            this.date = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         *
         */
        public Label() {
        }

        /**
         *
         * @param makerLine
         * @param title
         * @param description
         * @param date
         * @param notes
         */
        public Label(String title, String makerLine, Object description, String notes, String date) {
            super();
            this.title = title;
            this.makerLine = makerLine;
            this.description = description;
            this.notes = notes;
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMakerLine() {
            return makerLine;
        }

        public void setMakerLine(String makerLine) {
            this.makerLine = makerLine;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(title);
            dest.writeValue(makerLine);
            dest.writeValue(description);
            dest.writeValue(notes);
            dest.writeValue(date);
        }

        public int describeContents() {
            return 0;
        }

    }

