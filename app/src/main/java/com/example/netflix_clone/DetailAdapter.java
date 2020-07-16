package com.example.netflix_clone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {

    private List<MovieModel> mMovieData;
    private Context mContext;

    private static final String IMG_URL = "https://image.tmdb.org/t/p/original";

    DetailAdapter(List<MovieModel> listMovieData){
        this.mMovieData = listMovieData;
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_movie_icon_title, parent,false);
        mContext = parent.getContext();
        DetailHolder detailHolder = new DetailHolder(view);
        return detailHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        MovieModel model = mMovieData.get(position);
        holder.mTitle.setText(model.getTitle());
        Glide.with(mContext).load(IMG_URL + model.getPoster_path()).into(holder.mImageIcon);

    }

    @Override
    public int getItemCount() {
        return mMovieData.size();
    }

    public static class DetailHolder extends RecyclerView.ViewHolder{

        ImageButton mImageIcon;
        TextView mTitle;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);
            mImageIcon = itemView.findViewById(R.id.rc_content_movieIcon);
            mTitle = itemView.findViewById(R.id.rc_content_movieTitle);
        }
    }
}
