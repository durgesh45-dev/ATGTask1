package com.example.atgtask;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Photos {

    @SerializedName("photos")
    Photo photo;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public class Photo {

        int page;
        int pages;
        @SerializedName("total")
        int total;
        @SerializedName("photo")
        ArrayList<PhotoSources> photoItems;

        public int getPage() {
            return page;
        }

        public int getPages() {
            return pages;
        }

        public int getTotal() {
            return total;
        }

        public ArrayList<PhotoSources> getPhotoItems() {
            return photoItems;
        }

    }
}


