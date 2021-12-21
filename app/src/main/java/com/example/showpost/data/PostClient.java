package com.example.showpost.data;

import com.example.showpost.model.PostModel;

import java.util.List;


import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    PostInterface postInterface;
    static PostClient instance;

      private  static final String URL="https://jsonplaceholder.typicode.com/";

    public PostClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterface=retrofit.create(PostInterface.class);

    }
   public static PostClient getInstance(){
        if(null==instance){
            instance =new PostClient();
        }
        return instance;
    }
    public Observable<List<PostModel>> getPosts(){
        return postInterface.getPost();
    }
}
