package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ArtObjectDetail implements Parcelable {

        @SerializedName("links")
        private Links links;
        @SerializedName("id")
        private String id;
        @SerializedName("priref")
        private String priref;
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
        @SerializedName("colors")
        private ArrayList mColors = new ArrayList<>();
        @SerializedName("colorsWithNormalization")
        private ArrayList<ColorsWithNormalization> colorsWithNormalization = null;
        @SerializedName("normalizedColors")
        private List<String> normalizedColors = null;
        @SerializedName("normalized32Colors")
        private List<String> normalized32Colors = null;
        @SerializedName("titles")
        private List<String> titles = null;
        @SerializedName("description")
        private String description;
        @SerializedName("labelText")
        private Object labelText;
        @SerializedName("objectTypes")
        private List<String> objectTypes = null;
        @SerializedName("objectCollection")
        private List<String> objectCollection = null;
        @SerializedName("makers")
        private List<Object> makers = null;
        @SerializedName("principalMakers")
        private List<PrincipalMaker> principalMakers = null;
        @SerializedName("plaqueDescriptionDutch")
        private String plaqueDescriptionDutch;
        @SerializedName("plaqueDescriptionEnglish")
        private String plaqueDescriptionEnglish;
        @SerializedName("principalMaker")
        private String principalMaker;
        @SerializedName("artistRole")
        private Object artistRole;
        @SerializedName("associations")
        private List<Object> associations = null;
        @SerializedName("acquisition")
        private Acquisition acquisition;
        @SerializedName("exhibitions")
        private List<Object> exhibitions = null;
        @SerializedName("materials")
        private List<String> materials = null;
        @SerializedName("techniques")
        private List<Object> techniques = null;
        @SerializedName("productionPlaces")
        private List<String> productionPlaces = null;
        @SerializedName("dating")
        private Dating dating;
        @SerializedName("classification")
        private Classification classification;
        @SerializedName("hasImage")
        private Boolean hasImage;
        @SerializedName("historicalPersons")
        private List<String> historicalPersons = null;
        @SerializedName("inscriptions")
        private List<Object> inscriptions = null;
        @SerializedName("documentation")
        private List<String> documentation = null;
        @SerializedName("catRefRPK")
        private List<Object> catRefRPK = null;
        @SerializedName("principalOrFirstMaker")
        private String principalOrFirstMaker;
        @SerializedName("dimensions")
        private List<Dimension> dimensions = null;
        @SerializedName("physicalProperties")
        private List<Object> physicalProperties = null;
        @SerializedName("physicalMedium")
        private String physicalMedium;
        @SerializedName("longTitle")
        private String longTitle;
        @SerializedName("subTitle")
        private String subTitle;
        @SerializedName("scLabelLine")
        private String scLabelLine;
        @SerializedName("label")
        private Label label;
        @SerializedName("showImage")
        private Boolean showImage;
        @SerializedName("location")
        private String location;

        public final static Parcelable.Creator<ArtObjectDetail> CREATOR = new Creator<ArtObjectDetail>() {

            public ArtObjectDetail createFromParcel(Parcel in) {
                return new ArtObjectDetail(in);
            }
            public ArtObjectDetail[] newArray(int size) {
                return (new ArtObjectDetail[size]);
            }
        };

        private ArtObjectDetail(Parcel in) {
            this.links = ((Links) in.readValue((Links.class.getClassLoader())));
            this.id = in.readString();
            this.priref = in.readString();
            this.objectNumber = in.readString();
            this.language = in.readString();
            this.title = in.readString();
            this.copyrightHolder = ((Object) in.readValue((Object.class.getClassLoader())));
            this.webImage = ((WebImage) in.readValue((WebImage.class.getClassLoader())));
            mColors = in.readArrayList(String.class.getClassLoader());
            this.colorsWithNormalization = in.readArrayList(ColorsWithNormalization.class.getClassLoader());
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
            in.readList(this.productionPlaces, (java.lang.String.class.getClassLoader()));
            this.dating = ((Dating) in.readValue((Dating.class.getClassLoader())));
            this.classification = ((Classification) in.readValue((Classification.class.getClassLoader())));
            this.hasImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
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
            this.showImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            this.location = ((String) in.readValue((String.class.getClassLoader())));
        }

        public ArtObjectDetail(Links links, String id, String priref, String objectNumber, String language, String title, Object copyrightHolder, WebImage webImage, ArrayList<String> colors, ArrayList<ColorsWithNormalization> colorsWithNormalization, List<String> normalizedColors, List<String> normalized32Colors, List<String> titles, String description, Object labelText, List<String> objectTypes, List<String> objectCollection, List<Object> makers, List<PrincipalMaker> principalMakers, String plaqueDescriptionDutch, String plaqueDescriptionEnglish, String principalMaker, Object artistRole, List<Object> associations, Acquisition acquisition, List<Object> exhibitions, List<String> materials, List<Object> techniques, List<String> productionPlaces, Dating dating, Classification classification, Boolean hasImage, List<String> historicalPersons, List<Object> inscriptions, List<String> documentation, List<Object> catRefRPK, String principalOrFirstMaker, List<Dimension> dimensions, List<Object> physicalProperties, String physicalMedium, String longTitle, String subTitle, String scLabelLine, Label label, Boolean showImage, String location) {
            super();
            this.links = links;
            this.id = id;
            this.priref = priref;
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
            this.labelText = labelText;
            this.objectTypes = objectTypes;
            this.objectCollection = objectCollection;
            this.makers = makers;
            this.principalMakers = principalMakers;
            this.plaqueDescriptionDutch = plaqueDescriptionDutch;
            this.plaqueDescriptionEnglish = plaqueDescriptionEnglish;
            this.principalMaker = principalMaker;
            this.artistRole = artistRole;
            this.associations = associations;
            this.acquisition = acquisition;
            this.exhibitions = exhibitions;
            this.materials = materials;
            this.techniques = techniques;
            this.productionPlaces = productionPlaces;
            this.dating = dating;
            this.classification = classification;
            this.hasImage = hasImage;
            this.historicalPersons = historicalPersons;
            this.inscriptions = inscriptions;
            this.documentation = documentation;
            this.catRefRPK = catRefRPK;
            this.principalOrFirstMaker = principalOrFirstMaker;
            this.dimensions = dimensions;
            this.physicalProperties = physicalProperties;
            this.physicalMedium = physicalMedium;
            this.longTitle = longTitle;
            this.subTitle = subTitle;
            this.scLabelLine = scLabelLine;
            this.label = label;
            this.showImage = showImage;
            this.location = location;
        }

        public Links getLinks() {
            return links;
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

        public ArrayList getColors() {
            return mColors;
        }
        public void setColors(ArrayList colors) {
            mColors = colors;
        }

        public List<ColorsWithNormalization> getColorsWithNormalization() {
            return colorsWithNormalization;
        }

        public void setColorsWithNormalization(ArrayList<ColorsWithNormalization> colorsWithNormalization) {
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

        public List<String> getProductionPlaces() {
            return productionPlaces;
        }

        public void setProductionPlaces(List<String> productionPlaces) {
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

        public Boolean getHasImage() {
            return hasImage;
        }

        public void setHasImage(Boolean hasImage) {
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

        public Boolean getShowImage() {
            return showImage;
        }

        public void setShowImage(Boolean showImage) {
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
            dest.writeString(id);
            dest.writeString(priref);
            dest.writeString(objectNumber);
            dest.writeString(language);
            dest.writeValue(title);
            dest.writeValue(copyrightHolder);
            dest.writeValue(webImage);
            dest.writeList(mColors);
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


