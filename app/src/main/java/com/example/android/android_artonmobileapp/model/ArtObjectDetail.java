package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ArtObjectDetail implements Parcelable {

    @SerializedName("id")
        private String id;
        @SerializedName("objectNumber")
        private String objectNumber;
        @SerializedName("language")
        private String language;
        @SerializedName("title")
        private String title;
        @SerializedName("copyrightHolder")
        private Object copyrightHolder;
        @SerializedName("webImage")
        private WebImage webImage;
    private List<String> mColors = null;
        @SerializedName("colorsWithNormalization")
        private List<ColorsWithNormalization> colorsWithNormalization = null;
        @SerializedName("normalizedColors")
        private List<String> normalizedColors = null;
        @SerializedName("normalized32Colors")
        private List<String> normalized32Colors = null;
        @SerializedName("titles")
        private List<String> titles = null;
        @SerializedName("description")
        private String description;
        @SerializedName("objectTypes")
        private List<String> objectTypes = null;
        @SerializedName("objectCollection")
        private List<String> objectCollection = null;
        @SerializedName("materials")
        private List<String> materials = null;
        @SerializedName("techniques")
        private List<Object> techniques = null;
        @SerializedName("dating")
        private Dating dating;
        @SerializedName("principalOrFirstMaker")
        private String principalOrFirstMaker;
        @SerializedName("dimensions")
        private List<Dimension> dimensions = null;
        @SerializedName("longTitle")
        private String longTitle;


        public final static Parcelable.Creator<ArtObjectDetail> CREATOR = new Creator<ArtObjectDetail>() {

            public ArtObjectDetail createFromParcel(Parcel in) {
                return new ArtObjectDetail(in);
            }
            public ArtObjectDetail[] newArray(int size) {
                return (new ArtObjectDetail[size]);
            }
        };

        private ArtObjectDetail(Parcel in) {
            this.id = in.readString();
            this.objectNumber = in.readString();
            this.language = in.readString();
            this.title = in.readString();
            this.copyrightHolder = in.readValue((Object.class.getClassLoader()));
            this.webImage = ((WebImage) in.readValue((WebImage.class.getClassLoader())));
            in.readList(mColors, (String.class.getClassLoader()));
            in.readList(this.colorsWithNormalization, (ColorsWithNormalization.class.getClassLoader()));
            in.readList(this.normalizedColors, (String.class.getClassLoader()));
            in.readList(this.normalized32Colors, (String.class.getClassLoader()));
            in.readList(this.titles, (String.class.getClassLoader()));
            this.description = in.readString();
            in.readList(this.objectTypes, (String.class.getClassLoader()));
            in.readList(this.objectCollection, (String.class.getClassLoader()));
            in.readList(this.materials, (String.class.getClassLoader()));
            in.readList(this.techniques, (Object.class.getClassLoader()));
            this.dating = ((Dating) in.readValue((Dating.class.getClassLoader())));
            this.principalOrFirstMaker = in.readString();
            in.readList(this.dimensions, (Dimension.class.getClassLoader()));
            this.longTitle = in.readString();
        }


    public ArtObjectDetail(String id, String objectNumber, String language, String title, Object copyrightHolder, WebImage webImage, ArrayList<String> colors, ArrayList<ColorsWithNormalization> colorsWithNormalization, List<String> normalizedColors, List<String> normalized32Colors, List<String> titles, String description, List<String> objectTypes, List<String> objectCollection, List<String> materials, List<Object> techniques, Dating dating, String principalOrFirstMaker, List<Dimension> dimensions, String longTitle) {
            super();
            this.id = id;
            this.objectNumber = objectNumber;
            this.language = language;
            this.title = title;
            this.copyrightHolder = copyrightHolder;
            this.webImage = webImage;
            mColors = colors;
            this.colorsWithNormalization = colorsWithNormalization;
            this.normalizedColors = normalizedColors;
            this.normalized32Colors = normalized32Colors;
            this.titles = titles;
            this.description = description;
            this.objectTypes = objectTypes;
            this.objectCollection = objectCollection;
            this.materials = materials;
            this.techniques = techniques;
            this.dating = dating;
            this.principalOrFirstMaker = principalOrFirstMaker;
            this.dimensions = dimensions;
            this.longTitle = longTitle;
        }


    public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getObjectNumber() {
            return objectNumber;
        }

        public void setObjectNumber(String objectNumber) {
            this.objectNumber = objectNumber;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getCopyrightHolder() {
            return copyrightHolder;
        }

        public void setCopyrightHolder(Object copyrightHolder) {
            this.copyrightHolder = copyrightHolder;
        }

        public WebImage getWebImage() {
            return webImage;
        }

        public void setWebImage(WebImage webImage) {
            this.webImage = webImage;
        }

    public List<String> getColors() {
        return mColors;
    }

    public void setColors(List<String> colors) {
        mColors = colors;
    }

    public List<ColorsWithNormalization> getColorsWithNormalization() {
        return colorsWithNormalization;
    }

    public void setColorsWithNormalization(List<ColorsWithNormalization> colorsWithNormalization) {
        this.colorsWithNormalization = colorsWithNormalization;
    }

        public List<String> getNormalizedColors() {
            return normalizedColors;
        }

        public void setNormalizedColors(List<String> normalizedColors) {
            this.normalizedColors = normalizedColors;
        }

        public List<String> getNormalized32Colors() {
            return normalized32Colors;
        }

        public void setNormalized32Colors(List<String> normalized32Colors) {
            this.normalized32Colors = normalized32Colors;
        }

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> titles) {
            this.titles = titles;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public List<String> getObjectTypes() {
            return objectTypes;
        }

        public void setObjectTypes(List<String> objectTypes) {
            this.objectTypes = objectTypes;
        }

        public List<String> getObjectCollection() {
            return objectCollection;
        }

        public void setObjectCollection(List<String> objectCollection) {
            this.objectCollection = objectCollection;
        }

        public List<String> getMaterials() {
            return materials;
        }

        public void setMaterials(List<String> materials) {
            this.materials = materials;
        }

        public List<Object> getTechniques() {
            return techniques;
        }

        public void setTechniques(List<Object> techniques) {
            this.techniques = techniques;
        }

        public Dating getDating() {
            return dating;
        }

        public void setDating(Dating dating) {
            this.dating = dating;
        }

        public String getPrincipalOrFirstMaker() {
            return principalOrFirstMaker;
        }

        public void setPrincipalOrFirstMaker(String principalOrFirstMaker) {
            this.principalOrFirstMaker = principalOrFirstMaker;
        }

        public List<Dimension> getDimensions() {
            return dimensions;
        }

        public void setDimensions(List<Dimension> dimensions) {
            this.dimensions = dimensions;
        }

        public String getLongTitle() {
            return longTitle;
        }

        public void setLongTitle(String longTitle) {
            this.longTitle = longTitle;
        }


        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(objectNumber);
            dest.writeString(language);
            dest.writeString(title);
            dest.writeValue(copyrightHolder);
            dest.writeValue(webImage);
            dest.writeList(mColors);
            dest.writeList(colorsWithNormalization);
            dest.writeList(normalizedColors);
            dest.writeList(normalized32Colors);
            dest.writeString(description);
            dest.writeList(objectTypes);
            dest.writeList(objectCollection);
            dest.writeList(materials);
            dest.writeList(techniques);
            dest.writeValue(dating);
            dest.writeString(principalOrFirstMaker);
            dest.writeList(dimensions);
            dest.writeString(longTitle);
        }

        public int describeContents() {
            return 0;
        }

    }

