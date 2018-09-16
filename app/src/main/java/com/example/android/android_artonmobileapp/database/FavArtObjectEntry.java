/*Copyright 2018 Eleni Kalkopoulou

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
  */
package com.example.android.android_artonmobileapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "fav_art")
public class FavArtObjectEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String artObjectId;
    private String title;
    private String maker;
    private String imageUrl;
    private String description;

    @Ignore
    public FavArtObjectEntry(String artObjectId, String title, String maker, String imageUrl, String description ) {
        this.artObjectId = artObjectId;
        this.title = title;
        this.maker = maker;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public FavArtObjectEntry(int id, String artObjectId, String title, String maker, String imageUrl, String description ) {
        this.id = id;
        this.artObjectId = artObjectId;
        this.title = title;
        this.maker = maker;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtObjectId() {
        return this.artObjectId;
    }

    public void setArtObjectId(String artObjectId) {
        this.artObjectId = artObjectId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

