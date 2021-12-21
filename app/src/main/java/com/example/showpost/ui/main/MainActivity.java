package com.example.showpost.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.showpost.R;
import com.example.showpost.model.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostAdapter postAdapter;
    RecyclerView recyclerView;
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.post_recycler_view);
        postAdapter=new PostAdapter();
        getWindow().setStatusBarColor(getColor(R.color.white));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(postAdapter);


        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postViewModel.mutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setMovieList(postModels);
            }
        });


    }
}