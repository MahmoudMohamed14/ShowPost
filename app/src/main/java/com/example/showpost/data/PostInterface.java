package com.example.showpost.data;

import com.example.showpost.model.PostModel;

import java.util.List;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Observable<List<PostModel>> getPost();
}
