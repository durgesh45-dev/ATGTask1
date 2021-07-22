package com.example.atgtask;

import com.google.gson.annotations.SerializedName;

public class PhotoSources {

    @SerializedName("id")
    String id;


    @SerializedName("url_s")
    String url;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
