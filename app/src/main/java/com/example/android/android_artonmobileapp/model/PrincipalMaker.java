package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrincipalMaker implements Parcelable
    {

        @SerializedName("name")
        private String name;
        @SerializedName("unFixedName")
        private Object unFixedName;
        @SerializedName("placeOfBirth")
        private String placeOfBirth;
        @SerializedName("dateOfBirth")
        private String dateOfBirth;
        @SerializedName("dateOfBirthPrecision")
        private Object dateOfBirthPrecision;
        @SerializedName("dateOfDeath")
        private String dateOfDeath;
        @SerializedName("dateOfDeathPrecision")
        private Object dateOfDeathPrecision;
        @SerializedName("placeOfDeath")
        private String placeOfDeath;
        @SerializedName("occupation")
        private List<String> occupation = null;
        @SerializedName("roles")
        private List<String> roles = null;
        @SerializedName("nationality")
        private String nationality;
        @SerializedName("biography")
        private Object biography;
        @SerializedName("productionPlaces")
        private List<String> productionPlaces = null;
        @SerializedName("qualification")
        private Object qualification;
        public final static Parcelable.Creator<PrincipalMaker> CREATOR = new Creator<PrincipalMaker>() {



            public PrincipalMaker createFromParcel(Parcel in) {
                return new PrincipalMaker(in);
            }

            public PrincipalMaker[] newArray(int size) {
                return (new PrincipalMaker[size]);
            }
        };

        private PrincipalMaker(Parcel in) {
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.unFixedName = ((Object) in.readValue((Object.class.getClassLoader())));
            this.placeOfBirth = ((String) in.readValue((String.class.getClassLoader())));
            this.dateOfBirth = ((String) in.readValue((String.class.getClassLoader())));
            this.dateOfBirthPrecision = ((Object) in.readValue((Object.class.getClassLoader())));
            this.dateOfDeath = ((String) in.readValue((String.class.getClassLoader())));
            this.dateOfDeathPrecision = ((Object) in.readValue((Object.class.getClassLoader())));
            this.placeOfDeath = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.occupation, (java.lang.String.class.getClassLoader()));
            in.readList(this.roles, (java.lang.String.class.getClassLoader()));
            this.nationality = ((String) in.readValue((String.class.getClassLoader())));
            this.biography = ((Object) in.readValue((Object.class.getClassLoader())));
            in.readList(this.productionPlaces, (java.lang.String.class.getClassLoader()));
            this.qualification = ((Object) in.readValue((Object.class.getClassLoader())));
        }

        public PrincipalMaker(String name, Object unFixedName, String placeOfBirth, String dateOfBirth, Object dateOfBirthPrecision, String dateOfDeath, Object dateOfDeathPrecision, String placeOfDeath, List<String> occupation, List<String> roles, String nationality, Object biography, List<String> productionPlaces, Object qualification) {
            super();
            this.name = name;
            this.unFixedName = unFixedName;
            this.placeOfBirth = placeOfBirth;
            this.dateOfBirth = dateOfBirth;
            this.dateOfBirthPrecision = dateOfBirthPrecision;
            this.dateOfDeath = dateOfDeath;
            this.dateOfDeathPrecision = dateOfDeathPrecision;
            this.placeOfDeath = placeOfDeath;
            this.occupation = occupation;
            this.roles = roles;
            this.nationality = nationality;
            this.biography = biography;
            this.productionPlaces = productionPlaces;
            this.qualification = qualification;
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

        public List<String> getProductionPlaces() {
            return productionPlaces;
        }

        public void setProductionPlaces(List<String> productionPlaces) {
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
