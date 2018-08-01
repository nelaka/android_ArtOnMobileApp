package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Classification implements Parcelable
{

    @SerializedName("iconClassIdentifier")
    @Expose
    private List<String> iconClassIdentifier = null;
    @SerializedName("iconClassDescription")
    @Expose
    private List<String> iconClassDescription = null;
    @SerializedName("motifs")
    @Expose
    private List<Object> motifs = null;
    @SerializedName("events")
    @Expose
    private List<Object> events = null;
    @SerializedName("periods")
    @Expose
    private List<Object> periods = null;
    @SerializedName("places")
    @Expose
    private List<Object> places = null;
    @SerializedName("people")
    @Expose
    private List<String> people = null;
    @SerializedName("objectNumbers")
    @Expose
    private List<String> objectNumbers = null;
    public final static Parcelable.Creator<Classification> CREATOR = new Creator<Classification>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Classification createFromParcel(Parcel in) {
            return new Classification(in);
        }

        public Classification[] newArray(int size) {
            return (new Classification[size]);
        }

    }
            ;

    protected Classification(Parcel in) {
        in.readList(this.iconClassIdentifier, (java.lang.String.class.getClassLoader()));
        in.readList(this.iconClassDescription, (java.lang.String.class.getClassLoader()));
        in.readList(this.motifs, (java.lang.Object.class.getClassLoader()));
        in.readList(this.events, (java.lang.Object.class.getClassLoader()));
        in.readList(this.periods, (java.lang.Object.class.getClassLoader()));
        in.readList(this.places, (java.lang.Object.class.getClassLoader()));
        in.readList(this.people, (java.lang.String.class.getClassLoader()));
        in.readList(this.objectNumbers, (java.lang.String.class.getClassLoader()));
    }

    public Classification() {
    }

    public List<String> getIconClassIdentifier() {
        return iconClassIdentifier;
    }

    public void setIconClassIdentifier(List<String> iconClassIdentifier) {
        this.iconClassIdentifier = iconClassIdentifier;
    }

    public List<String> getIconClassDescription() {
        return iconClassDescription;
    }

    public void setIconClassDescription(List<String> iconClassDescription) {
        this.iconClassDescription = iconClassDescription;
    }

    public List<Object> getMotifs() {
        return motifs;
    }

    public void setMotifs(List<Object> motifs) {
        this.motifs = motifs;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void setEvents(List<Object> events) {
        this.events = events;
    }

    public List<Object> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Object> periods) {
        this.periods = periods;
    }

    public List<Object> getPlaces() {
        return places;
    }

    public void setPlaces(List<Object> places) {
        this.places = places;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getObjectNumbers() {
        return objectNumbers;
    }

    public void setObjectNumbers(List<String> objectNumbers) {
        this.objectNumbers = objectNumbers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(iconClassIdentifier);
        dest.writeList(iconClassDescription);
        dest.writeList(motifs);
        dest.writeList(events);
        dest.writeList(periods);
        dest.writeList(places);
        dest.writeList(people);
        dest.writeList(objectNumbers);
    }

    public int describeContents() {
        return 0;
    }

}

