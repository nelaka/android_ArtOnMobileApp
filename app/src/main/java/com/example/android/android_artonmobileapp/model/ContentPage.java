package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentPage implements Parcelable {

    public final static Parcelable.Creator<ContentPage> CREATOR = new Creator<ContentPage>() {


        @SuppressWarnings({"unchecked"})
        public ContentPage createFromParcel(Parcel in) {
            return new ContentPage(in);
        }

        public ContentPage[] newArray(int size) {
            return (new ContentPage[size]);
        }

    };
    @SerializedName("categoryItems")
    private List<Style> categoryItems = null;
    @SerializedName("id")
    private String id;
    @SerializedName("guid")
    private String guid;
    @SerializedName("lang")
    private String lang;
    @SerializedName("compactHeader")
    private Boolean compactHeader;
    @SerializedName("shortcutKeywords")
    private List<Object> shortcutKeywords = null;
    @SerializedName("otherLangs")
    private List<String> otherLangs = null;
    @SerializedName("headerImage")
    private String headerImage;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private Object description;
    @SerializedName("createdOn")
    private String createdOn;
    @SerializedName("updatedOn")
    private String updatedOn;

    protected ContentPage(Parcel in) {
        in.readList(this.categoryItems, (Style.class.getClassLoader()));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.guid = ((String) in.readValue((String.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
        this.compactHeader = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.shortcutKeywords, (java.lang.Object.class.getClassLoader()));
        in.readList(this.otherLangs, (java.lang.String.class.getClassLoader()));
        this.headerImage = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = in.readValue((Object.class.getClassLoader()));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedOn = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ContentPage() {
    }

    public List<Style> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<Style> categoryItems) {
        this.categoryItems = categoryItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getCompactHeader() {
        return compactHeader;
    }

    public void setCompactHeader(Boolean compactHeader) {
        this.compactHeader = compactHeader;
    }

    public List<Object> getShortcutKeywords() {
        return shortcutKeywords;
    }

    public void setShortcutKeywords(List<Object> shortcutKeywords) {
        this.shortcutKeywords = shortcutKeywords;
    }

    public List<String> getOtherLangs() {
        return otherLangs;
    }

    public void setOtherLangs(List<String> otherLangs) {
        this.otherLangs = otherLangs;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }


    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(categoryItems);
        dest.writeValue(id);
        dest.writeValue(guid);
        dest.writeValue(lang);
        dest.writeValue(compactHeader);
        dest.writeList(shortcutKeywords);
        dest.writeList(otherLangs);
        dest.writeValue(headerImage);
        dest.writeValue(thumbnail);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(createdOn);
        dest.writeValue(updatedOn);
    }

    public int describeContents() {
        return 0;
    }

}