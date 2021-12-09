package com.example.showpost.data;

import com.example.showpost.model.PostModel;

import java.util.List;

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
                .build();
        postInterface=retrofit.create(PostInterface.class);

    }
   public static PostClient getInstance(){
        if(null==instance){
            instance =new PostClient();
        }
        return instance;
    }
    public Call<List<PostModel>> getPosts(){
        return postInterface.getPost();
    }
}
