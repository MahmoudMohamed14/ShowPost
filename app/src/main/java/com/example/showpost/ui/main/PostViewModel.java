package com.example.showpost.ui.main;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.showpost.data.PostClient;
import com.example.showpost.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<List<PostModel>> mutableLiveData=new MutableLiveData();
public void  getPosts(){
    PostClient.getInstance().getPosts().enqueue(new Callback<List<PostModel>>() {
        @Override
        public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
            mutableLiveData.setValue(response.body());
            Log.d("mohamed","mahmoud");
        }

        @Override
        public void onFailure(Call<List<PostModel>> call, Throwable t) {
            Log.d("erroe_her",t.getMessage());


        }
    });
}

}
