package com.example.showpost.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.showpost.R;
import com.example.showpost.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.HolderAdapter> {
    List<PostModel> modelArrayList = new ArrayList<PostModel>();

    @NonNull
    @Override
    public HolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderAdapter(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAdapter holder, int position) {
holder.titleTv.setText(modelArrayList.get(position).getTitle());
holder.bodyTv.setText(modelArrayList.get(position).getBody());
holder.idTv.setText(""+modelArrayList.get(position).getId());

    }

    public void setMovieList(List<PostModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class HolderAdapter extends RecyclerView.ViewHolder {
        TextView bodyTv,titleTv,idTv;


        public HolderAdapter(@NonNull View itemView) {
            super(itemView);
          bodyTv=  itemView.findViewById(R.id.body_tv);
          titleTv=itemView.findViewById(R.id.title_tv);
          idTv=  itemView.findViewById(R.id.id_tv);

        }
    }
}
