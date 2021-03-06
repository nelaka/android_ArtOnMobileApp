package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtObjectDetail implements Parcelable {

    @SerializedName("objectNumber")
    private String mObjectId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("webImage")
    private WebImage mWebImage;
    @SerializedName("normalizedColors")
    private List<String> mNormalizedColors = null;
    @SerializedName("plaqueDescriptionEnglish")
    private String mPlaqueDescriptionEnglish;
    @SerializedName("dating")
    private Dating dating;
    @SerializedName("principalOrFirstMaker")
    private String mPrincipalOrFirstMaker;
    @SerializedName("dimensions")
    private List<Dimension> dimensions = null;
    @SerializedName("longTitle")
    private String mLongTitle;

    public final static Parcelable.Creator<ArtObjectDetail> CREATOR = new Creator<ArtObjectDetail>() {

        public ArtObjectDetail createFromParcel(Parcel in) {
            return new ArtObjectDetail(in);
        }

        public ArtObjectDetail[] newArray(int size) {
            return (new ArtObjectDetail[size]);
        }
    };

    private ArtObjectDetail(Parcel in) {
        mObjectId = in.readString();
        mTitle = in.readString();
        mWebImage = ((WebImage) in.readValue((WebImage.class.getClassLoader())));
        in.readList(mNormalizedColors, String.class.getClassLoader());
        mPlaqueDescriptionEnglish = in.readString();
        this.dating = ((Dating) in.readValue((Dating.class.getClassLoader())));
        mPrincipalOrFirstMaker = in.readString();
        in.readList(this.dimensions, (Dimension.class.getClassLoader()));
        mLongTitle = in.readString();
    }

    public ArtObjectDetail() {
    }

    public String getTitle() {
        return mTitle;
    }

    public WebImage getWebImage() {
        return mWebImage;
    }

    public List<String> getNormalizedColors() {
        return mNormalizedColors;
    }

    public String getPlaqueDescriptionEnglish() {
        return mPlaqueDescriptionEnglish;
    }

    public String getPrincipalOrFirstMaker() {
        return mPrincipalOrFirstMaker;
    }

    public String getLongTitle() {
        return mLongTitle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mObjectId);
        dest.writeString(mTitle);
        dest.writeValue(mWebImage);
        dest.writeList(mNormalizedColors);
        dest.writeValue(mPlaqueDescriptionEnglish);
        dest.writeValue(dating);
        dest.writeString(mPrincipalOrFirstMaker);
        dest.writeList(dimensions);
        dest.writeString(mLongTitle);
    }

    public int describeContents() {
        return 0;
    }

}
