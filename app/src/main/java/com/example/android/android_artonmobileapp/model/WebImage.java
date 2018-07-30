package com.example.android.android_artonmobileapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class WebImage implements Parcelable {
    /*   @SerializedName("guid")
       private String mGuid;
       @SerializedName("offsetPercentageX")
       private Integer mOffsetPercentageX;
       @SerializedName("offsetPercentageY")
       private Integer mOffsetPercentageY;
       @SerializedName("width")
       private Integer mWidth;
       @SerializedName("height")
       private Integer mHeight;*/
        @SerializedName("url")
        private String mUrl;

        public final static Parcelable.Creator<WebImage> CREATOR = new Creator<WebImage>() {
            public WebImage createFromParcel(Parcel in) {
                return new WebImage(in);
            }

            public WebImage[] newArray(int size) {
                return (new WebImage[size]);
            }
        };

        private WebImage(Parcel in) {
         /*   mGuid = in.readString();
            mOffsetPercentageX = in.readInt();
            mOffsetPercentageY = in.readInt();
            mWidth = in.readInt();
            mHeight = in.readInt();*/
            mUrl = in.readString();
        }

    public WebImage(/*String guid, Integer offsetPercentageX, Integer offsetPercentageY, Integer width, Integer height,*/ String url) {
            super();
            /*mGuid = guid;
            mOffsetPercentageX = offsetPercentageX;
            mOffsetPercentageY = offsetPercentageY;
            mWidth = width;
            mHeight = height;*/
            mUrl = url;
        }

    /*  public String getGuid() {
          return mGuid;
      }
      public Integer getOffsetPercentageX() {
          return mOffsetPercentageX;
      }
      public Integer getOffsetPercentageY() {
          return mOffsetPercentageY;
      }
      public Integer getWidth() {
          return mWidth;
      }
      public Integer getHeight() {
          return mHeight;
      }
      */
    public String getUrl() {
            return mUrl;
        }

        public void writeToParcel(Parcel out, int flags) {
          /*  out.writeString(mGuid);
            out.writeInt(mOffsetPercentageX);
            out.writeInt(mOffsetPercentageY);
            out.writeInt(mWidth);
            out.writeInt(mHeight);*/
            out.writeString(mUrl);
        }

        public int describeContents() {
            return 0;
        }

    }
