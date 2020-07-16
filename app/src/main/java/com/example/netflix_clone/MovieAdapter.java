package com.example.netflix_clone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private List<MovieModel> mDataSet;
    private List<String> mListCategory;
    private DetailAdapter mAdapter;
    private Context mContext;

    public MovieAdapter(List<MovieModel> dataSet, List<String> lstCategory){
        this.mDataSet = dataSet;
        this.mListCategory = lstCategory;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_content, parent, false);
        MovieHolder mHolder = new MovieHolder(view);

        mContext = parent.getContext();
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
//        MovieModel model = mDataSet.get(position);
//        String individualText = model.getTitle();
//        holder.mTextView.setText(individualText);
        holder.mTextView.setText(this.mListCategory.get(position));

        mAdapter = new DetailAdapter(this.mDataSet);
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return mListCategory.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private RecyclerView mRecyclerView;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.rc_content_Label);
            mRecyclerView = itemView.findViewById(R.id.rc_content_popular);
        }
    }
}
