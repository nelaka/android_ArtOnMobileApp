package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrincipalMaker implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unFixedName")
    @Expose
    private Object unFixedName;
    @SerializedName("placeOfBirth")
    @Expose
    private String placeOfBirth;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("dateOfBirthPrecision")
    @Expose
    private Object dateOfBirthPrecision;
    @SerializedName("dateOfDeath")
    @Expose
    private String dateOfDeath;
    @SerializedName("dateOfDeathPrecision")
    @Expose
    private Object dateOfDeathPrecision;
    @SerializedName("placeOfDeath")
    @Expose
    private String placeOfDeath;
    @SerializedName("occupation")
    @Expose
    private List<String> occupation = null;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("biography")
    @Expose
    private Object biography;
    @SerializedName("productionPlaces")
    @Expose
    private List<Object> productionPlaces = null;
    @SerializedName("qualification")
    @Expose
    private Object qualification;
    public final static Parcelable.Creator<PrincipalMaker> CREATOR = new Creator<PrincipalMaker>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PrincipalMaker createFromParcel(Parcel in) {
            return new PrincipalMaker(in);
        }

        public PrincipalMaker[] newArray(int size) {
            return (new PrincipalMaker[size]);
        }

    }
            ;

    private PrincipalMaker(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.unFixedName = in.readValue((Object.class.getClassLoader()));
        this.placeOfBirth = ((String) in.readValue((String.class.getClassLoader())));
        this.dateOfBirth = ((String) in.readValue((String.class.getClassLoader())));
        this.dateOfBirthPrecision = in.readValue((Object.class.getClassLoader()));
        this.dateOfDeath = ((String) in.readValue((String.class.getClassLoader())));
        this.dateOfDeathPrecision = in.readValue((Object.class.getClassLoader()));
        this.placeOfDeath = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.occupation, (java.lang.String.class.getClassLoader()));
        in.readList(this.roles, (java.lang.String.class.getClassLoader()));
        this.nationality = ((String) in.readValue((String.class.getClassLoader())));
        this.biography = in.readValue((Object.class.getClassLoader()));
        in.readList(this.productionPlaces, (java.lang.Object.class.getClassLoader()));
        this.qualification = in.readValue((Object.class.getClassLoader()));
    }

    public PrincipalMaker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getUnFixedName() {
        return unFixedName;
    }

    public void setUnFixedName(Object unFixedName) {
        this.unFixedName = unFixedName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object getDateOfBirthPrecision() {
        return dateOfBirthPrecision;
    }

    public void setDateOfBirthPrecision(Object dateOfBirthPrecision) {
        this.dateOfBirthPrecision = dateOfBirthPrecision;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Object getDateOfDeathPrecision() {
        return dateOfDeathPrecision;
    }

    public void setDateOfDeathPrecision(Object dateOfDeathPrecision) {
        this.dateOfDeathPrecision = dateOfDeathPrecision;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Object getBiography() {
        return biography;
    }

    public void setBiography(Object biography) {
        this.biography = biography;
    }

    public List<Object> getProductionPlaces() {
        return productionPlaces;
    }

    public void setProductionPlaces(List<Object> productionPlaces) {
        this.productionPlaces = productionPlaces;
    }

    public Object getQualification() {
        return qualification;
    }

    public void setQualification(Object qualification) {
        this.qualification = qualification;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(unFixedName);
        dest.writeValue(placeOfBirth);
        dest.writeValue(dateOfBirth);
        dest.writeValue(dateOfBirthPrecision);
        dest.writeValue(dateOfDeath);
        dest.writeValue(dateOfDeathPrecision);
        dest.writeValue(placeOfDeath);
        dest.writeList(occupation);
        dest.writeList(roles);
        dest.writeValue(nationality);
        dest.writeValue(biography);
        dest.writeList(productionPlaces);
        dest.writeValue(qualification);
    }

    public int describeContents() {
        return 0;
    }

}
