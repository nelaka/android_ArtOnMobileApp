package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ArtObjectDetail implements Parcelable
    {

        @SerializedName("links")
        @Expose
        private Links links;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("priref")
        @Expose
        private String priref;
        @SerializedName("objectNumber")
        @Expose
        private String objectNumber;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("copyrightHolder")
        @Expose
        private Object copyrightHolder;
        @SerializedName("webImage")
        @Expose
        private WebImage webImage;
        @SerializedName("colors")
        @Expose
        private List<String> colors = null;
        @SerializedName("colorsWithNormalization")
        @Expose
        private List<ColorsWithNormalization> colorsWithNormalization = null;
        @SerializedName("normalizedColors")
        @Expose
        private List<String> normalizedColors = null;
        @SerializedName("normalized32Colors")
        @Expose
        private List<String> normalized32Colors = null;
        @SerializedName("titles")
        @Expose
        private List<String> titles = null;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("labelText")
        @Expose
        private Object labelText;
        @SerializedName("objectTypes")
        @Expose
        private List<String> objectTypes = null;
        @SerializedName("objectCollection")
        @Expose
        private List<String> objectCollection = null;
        @SerializedName("makers")
        @Expose
        private List<Object> makers = null;
        @SerializedName("principalMakers")
        @Expose
        private List<PrincipalMaker> principalMakers = null;
        @SerializedName("plaqueDescriptionDutch")
        @Expose
        private String plaqueDescriptionDutch;
        @SerializedName("plaqueDescriptionEnglish")
        @Expose
        private String plaqueDescriptionEnglish;
        @SerializedName("principalMaker")
        @Expose
        private String principalMaker;
        @SerializedName("artistRole")
        @Expose
        private Object artistRole;
        @SerializedName("associations")
        @Expose
        private List<Object> associations = null;
        @SerializedName("acquisition")
        @Expose
        private Acquisition acquisition;
        @SerializedName("exhibitions")
        @Expose
        private List<Object> exhibitions = null;
        @SerializedName("materials")
        @Expose
        private List<String> materials = null;
        @SerializedName("techniques")
        @Expose
        private List<Object> techniques = null;
        @SerializedName("productionPlaces")
        @Expose
        private List<Object> productionPlaces = null;
        @SerializedName("dating")
        @Expose
        private Dating dating;
        @SerializedName("classification")
        @Expose
        private Classification classification;
        @SerializedName("hasImage")
        @Expose
        private boolean hasImage;
        @SerializedName("historicalPersons")
        @Expose
        private List<String> historicalPersons = null;
        @SerializedName("inscriptions")
        @Expose
        private List<Object> inscriptions = null;
        @SerializedName("documentation")
        @Expose
        private List<String> documentation = null;
        @SerializedName("catRefRPK")
        @Expose
        private List<Object> catRefRPK = null;
        @SerializedName("principalOrFirstMaker")
        @Expose
        private String principalOrFirstMaker;
        @SerializedName("dimensions")
        @Expose
        private List<Dimension> dimensions = null;
        @SerializedName("physicalProperties")
        @Expose
        private List<Object> physicalProperties = null;
        @SerializedName("physicalMedium")
        @Expose
        private String physicalMedium;
        @SerializedName("longTitle")
        @Expose
        private String longTitle;
        @SerializedName("subTitle")
        @Expose
        private String subTitle;
        @SerializedName("scLabelLine")
        @Expose
        private String scLabelLine;
        @SerializedName("label")
        @Expose
        private Label label;
        @SerializedName("showImage")
        @Expose
        private boolean showImage;
        @SerializedName("location")
        @Expose
        private String location;
        public final static Parcelable.Creator<ArtObjectDetail> CREATOR = new Creator<ArtObjectDetail>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public ArtObjectDetail createFromParcel(Parcel in) {
                return new ArtObjectDetail(in);
            }

            public ArtObjectDetail[] newArray(int size) {
                return (new ArtObjectDetail[size]);
            }

        }
                ;

        protected ArtObjectDetail(Parcel in) {
            this.links = ((Links) in.readValue((Links.class.getClassLoader())));
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.priref = ((String) in.readValue((String.class.getClassLoader())));
            this.objectNumber = ((String) in.readValue((String.class.getClassLoader())));
            this.language = ((String) in.readValue((String.class.getClassLoader())));
            this.title = ((String) in.readValue((String.class.getClassLoader())));
            this.copyrightHolder = ((Object) in.readValue((Object.class.getClassLoader())));
            this.webImage = ((WebImage) in.readValue((WebImage.class.getClassLoader())));
            in.readList(this.colors, (java.lang.String.class.getClassLoader()));
            in.readList(this.colorsWithNormalization, (ColorsWithNormalization.class.getClassLoader()));
            in.readList(this.normalizedColors, (java.lang.String.class.getClassLoader()));
            in.readList(this.normalized32Colors, (java.lang.String.class.getClassLoader()));
            in.readList(this.titles, (java.lang.String.class.getClassLoader()));
            this.description = ((String) in.readValue((String.class.getClassLoader())));
            this.labelText = ((Object) in.readValue((Object.class.getClassLoader())));
            in.readList(this.objectTypes, (java.lang.String.class.getClassLoader()));
            in.readList(this.objectCollection, (java.lang.String.class.getClassLoader()));
            in.readList(this.makers, (java.lang.Object.class.getClassLoader()));
            in.readList(this.principalMakers, (PrincipalMaker.class.getClassLoader()));
            this.plaqueDescriptionDutch = ((String) in.readValue((String.class.getClassLoader())));
            this.plaqueDescriptionEnglish = ((String) in.readValue((String.class.getClassLoader())));
            this.principalMaker = ((String) in.readValue((String.class.getClassLoader())));
            this.artistRole = ((Object) in.readValue((Object.class.getClassLoader())));
            in.readList(this.associations, (java.lang.Object.class.getClassLoader()));
            this.acquisition = ((Acquisition) in.readValue((Acquisition.class.getClassLoader())));
            in.readList(this.exhibitions, (java.lang.Object.class.getClassLoader()));
            in.readList(this.materials, (java.lang.String.class.getClassLoader()));
            in.readList(this.techniques, (java.lang.Object.class.getClassLoader()));
            in.readList(this.productionPlaces, (java.lang.Object.class.getClassLoader()));
            this.dating = ((Dating) in.readValue((Dating.class.getClassLoader())));
            this.classification = ((Classification) in.readValue((Classification.class.getClassLoader())));
            this.hasImage = ((boolean) in.readValue((boolean.class.getClassLoader())));
            in.readList(this.historicalPersons, (java.lang.String.class.getClassLoader()));
            in.readList(this.inscriptions, (java.lang.Object.class.getClassLoader()));
            in.readList(this.documentation, (java.lang.String.class.getClassLoader()));
            in.readList(this.catRefRPK, (java.lang.Object.class.getClassLoader()));
            this.principalOrFirstMaker = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.dimensions, (Dimension.class.getClassLoader()));
            in.readList(this.physicalProperties, (java.lang.Object.class.getClassLoader()));
            this.physicalMedium = ((String) in.readValue((String.class.getClassLoader())));
            this.longTitle = ((String) in.readValue((String.class.getClassLoader())));
            this.subTitle = ((String) in.readValue((String.class.getClassLoader())));
            this.scLabelLine = ((String) in.readValue((String.class.getClassLoader())));
            this.label = ((Label) in.readValue((Label.class.getClassLoader())));
            this.showImage = ((boolean) in.readValue((boolean.class.getClassLoader())));
            this.location = ((String) in.readValue((String.class.getClassLoader())));
        }

        public ArtObjectDetail() {
        }

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPriref() {
            return priref;
        }

        public void setPriref(String priref) {
            this.priref = priref;
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
            return colors;
        }

        public void setColors(List<String> colors) {
            this.colors = colors;
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

        public Object getLabelText() {
            return labelText;
        }

        public void setLabelText(Object labelText) {
            this.labelText = labelText;
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

        public List<Object> getMakers() {
            return makers;
        }

        public void setMakers(List<Object> makers) {
            this.makers = makers;
        }

        public List<PrincipalMaker> getPrincipalMakers() {
            return principalMakers;
        }

        public void setPrincipalMakers(List<PrincipalMaker> principalMakers) {
            this.principalMakers = principalMakers;
        }

        public String getPlaqueDescriptionDutch() {
            return plaqueDescriptionDutch;
        }

        public void setPlaqueDescriptionDutch(String plaqueDescriptionDutch) {
            this.plaqueDescriptionDutch = plaqueDescriptionDutch;
        }

        public String getPlaqueDescriptionEnglish() {
            return plaqueDescriptionEnglish;
        }

        public void setPlaqueDescriptionEnglish(String plaqueDescriptionEnglish) {
            this.plaqueDescriptionEnglish = plaqueDescriptionEnglish;
        }

        public String getPrincipalMaker() {
            return principalMaker;
        }

        public void setPrincipalMaker(String principalMaker) {
            this.principalMaker = principalMaker;
        }

        public Object getArtistRole() {
            return artistRole;
        }

        public void setArtistRole(Object artistRole) {
            this.artistRole = artistRole;
        }

        public List<Object> getAssociations() {
            return associations;
        }

        public void setAssociations(List<Object> associations) {
            this.associations = associations;
        }

        public Acquisition getAcquisition() {
            return acquisition;
        }

        public void setAcquisition(Acquisition acquisition) {
            this.acquisition = acquisition;
        }

        public List<Object> getExhibitions() {
            return exhibitions;
        }

        public void setExhibitions(List<Object> exhibitions) {
            this.exhibitions = exhibitions;
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

        public List<Object> getProductionPlaces() {
            return productionPlaces;
        }

        public void setProductionPlaces(List<Object> productionPlaces) {
            this.productionPlaces = productionPlaces;
        }

        public Dating getDating() {
            return dating;
        }

        public void setDating(Dating dating) {
            this.dating = dating;
        }

        public Classification getClassification() {
            return classification;
        }

        public void setClassification(Classification classification) {
            this.classification = classification;
        }

        public boolean isHasImage() {
            return hasImage;
        }

        public void setHasImage(boolean hasImage) {
            this.hasImage = hasImage;
        }

        public List<String> getHistoricalPersons() {
            return historicalPersons;
        }

        public void setHistoricalPersons(List<String> historicalPersons) {
            this.historicalPersons = historicalPersons;
        }

        public List<Object> getInscriptions() {
            return inscriptions;
        }

        public void setInscriptions(List<Object> inscriptions) {
            this.inscriptions = inscriptions;
        }

        public List<String> getDocumentation() {
            return documentation;
        }

        public void setDocumentation(List<String> documentation) {
            this.documentation = documentation;
        }

        public List<Object> getCatRefRPK() {
            return catRefRPK;
        }

        public void setCatRefRPK(List<Object> catRefRPK) {
            this.catRefRPK = catRefRPK;
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

        public List<Object> getPhysicalProperties() {
            return physicalProperties;
        }

        public void setPhysicalProperties(List<Object> physicalProperties) {
            this.physicalProperties = physicalProperties;
        }

        public String getPhysicalMedium() {
            return physicalMedium;
        }

        public void setPhysicalMedium(String physicalMedium) {
            this.physicalMedium = physicalMedium;
        }

        public String getLongTitle() {
            return longTitle;
        }

        public void setLongTitle(String longTitle) {
            this.longTitle = longTitle;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getScLabelLine() {
            return scLabelLine;
        }

        public void setScLabelLine(String scLabelLine) {
            this.scLabelLine = scLabelLine;
        }

        public Label getLabel() {
            return label;
        }

        public void setLabel(Label label) {
            this.label = label;
        }

        public boolean isShowImage() {
            return showImage;
        }

        public void setShowImage(boolean showImage) {
            this.showImage = showImage;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(links);
            dest.writeValue(id);
            dest.writeValue(priref);
            dest.writeValue(objectNumber);
            dest.writeValue(language);
            dest.writeValue(title);
            dest.writeValue(copyrightHolder);
            dest.writeValue(webImage);
            dest.writeList(colors);
            dest.writeList(colorsWithNormalization);
            dest.writeList(normalizedColors);
            dest.writeList(normalized32Colors);
            dest.writeList(titles);
            dest.writeValue(description);
            dest.writeValue(labelText);
            dest.writeList(objectTypes);
            dest.writeList(objectCollection);
            dest.writeList(makers);
            dest.writeList(principalMakers);
            dest.writeValue(plaqueDescriptionDutch);
            dest.writeValue(plaqueDescriptionEnglish);
            dest.writeValue(principalMaker);
            dest.writeValue(artistRole);
            dest.writeList(associations);
            dest.writeValue(acquisition);
            dest.writeList(exhibitions);
            dest.writeList(materials);
            dest.writeList(techniques);
            dest.writeList(productionPlaces);
            dest.writeValue(dating);
            dest.writeValue(classification);
            dest.writeValue(hasImage);
            dest.writeList(historicalPersons);
            dest.writeList(inscriptions);
            dest.writeList(documentation);
            dest.writeList(catRefRPK);
            dest.writeValue(principalOrFirstMaker);
            dest.writeList(dimensions);
            dest.writeList(physicalProperties);
            dest.writeValue(physicalMedium);
            dest.writeValue(longTitle);
            dest.writeValue(subTitle);
            dest.writeValue(scLabelLine);
            dest.writeValue(label);
            dest.writeValue(showImage);
            dest.writeValue(location);
        }

        public int describeContents() {
            return 0;
        }

    }
