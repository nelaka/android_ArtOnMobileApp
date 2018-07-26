package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ArtObject implements Parcelable {

        @SerializedName("links")
        private Links mLinks;
        @SerializedName("id")
        private String mId;
        @SerializedName("objectNumber")
        private String mObjectNumber;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("hasImage")
        private Boolean mHasImage;
        @SerializedName("principalOrFirstMaker")
        private String mPrincipalOrFirstMaker;
        @SerializedName("longTitle")
        private String mLongTitle;
        @SerializedName("showImage")
        private Boolean mShowImage;
        @SerializedName("permitDownload")
        private Boolean mPermitDownload;
        @SerializedName("webImage")
        private WebImage mWebImage;
        //   @SerializedName("productionPlaces")
//   private List<String> mProductionPlaces = null;

        public final static Parcelable.Creator<ArtObject> CREATOR = new Creator<ArtObject>() {
            public ArtObject createFromParcel(Parcel in) { return new ArtObject(in); }
            public ArtObject[] newArray(int size) { return (new ArtObject[size]); }
        };

        private ArtObject(Parcel in) {
            mLinks = (Links) in.readValue(Links.class.getClassLoader());
            mId = in.readString();
            mObjectNumber = in.readString();
            mTitle = in.readString();
            mHasImage = ((Boolean) in.readValue(Boolean.class.getClassLoader()));
            mPrincipalOrFirstMaker = in.readString();
            mLongTitle = in.readString();
            mShowImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            mPermitDownload = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            mWebImage = (WebImage) in.readValue(WebImage.class.getClassLoader());
            //   in.readList(mProductionPlaces, (String.class.getClassLoader()));
        }


        public ArtObject(Links links, String id, String objectNumber, String title, Boolean hasImage, String principalOrFirstMaker, String longTitle, Boolean showImage, Boolean permitDownload, WebImage webImage /*, List<String> productionPlaces*/) {
            super();
            mLinks = links;
            mId = id;
            mObjectNumber = objectNumber;
            mTitle = title;
            mHasImage = hasImage;
            mPrincipalOrFirstMaker = principalOrFirstMaker;
            mLongTitle = longTitle;
            mShowImage = showImage;
            mPermitDownload = permitDownload;
            mWebImage = webImage;
            //  mProductionPlaces = productionPlaces;
        }

        public Links getLinks() {
            return mLinks;
        }

        public String getId() {
            return mId;
        }
        public String getObjectNumber() {
            return mObjectNumber;
        }
        public String getTitle() {
            return mTitle;
        }

        public Boolean getHasImage() {
            return mHasImage;
        }

        public String getPrincipalOrFirstMaker() {
            return mPrincipalOrFirstMaker;
        }

        public String getLongTitle() {
            return mLongTitle;
        }

        public Boolean getShowImage() {
            return mShowImage;
        }

        public Boolean getPermitDownload() {
            return mPermitDownload;
        }

        public WebImage getWebImage() {
            return mWebImage;
        }

  /*  public List<String> getProductionPlaces() {
        return mProductionPlaces;
    }
*/

        @Override
        public void writeToParcel(Parcel out, int flags) {
            out.writeValue(mLinks);
            out.writeString(mId);
            out.writeString(mObjectNumber);
            out.writeString(mTitle);
            out.writeValue(mHasImage);
            out.writeString(mPrincipalOrFirstMaker);
            out.writeString(mLongTitle);
            out.writeValue(mShowImage);
            out.writeValue(mPermitDownload);
            out.writeValue(mWebImage);
            //   out.writeValue(mProductionPlaces);
        }

        @Override
        public int describeContents() {
            return 0;
        }
    }
