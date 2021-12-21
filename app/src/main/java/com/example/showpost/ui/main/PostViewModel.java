package com.example.showpost.ui.main;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.showpost.data.PostClient;
import com.example.showpost.model.PostModel;

import java.util.List;






import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

public class PostViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<List<PostModel>> mutableLiveData = new MutableLiveData();

    public void getPosts() {
       Observable<List<PostModel>> observable;
        observable = PostClient.getInstance().getPosts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->mutableLiveData.setValue(o));

    }
}
