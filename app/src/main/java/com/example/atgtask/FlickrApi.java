package com.example.atgtask;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface FlickrApi {
    @GET("services/rest/?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    Call<Photos> getPhotos();
    //@Query("method") String method,
    //                           @Field("per_page") int perPage,
    //                           @Field("page") int page,
    //                           @Field("api_key") String api_key,
    //                           @Field("format") String format,
    //                           @Field("nojsoncallback") int cBack,
    //                           @Field("extras") String s
}
