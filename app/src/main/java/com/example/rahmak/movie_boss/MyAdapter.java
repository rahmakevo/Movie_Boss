package com.example.rahmak.movie_boss;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rahmak on 9/22/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Results> resultsArrayList = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context, ArrayList<Results> mResultsArrayList) {
        this.resultsArrayList = mResultsArrayList;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.bindResults(resultsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle, textViewRating;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewMovie);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRating = itemView.findViewById(R.id.textViewRating);

            context = itemView.getContext();
        }

        public void bindResults(Results results){
            textViewTitle.setText(results.getTitle());
            textViewRating.setText("Rating: "+ results.getVote_average() + "/10");
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500"+results.getPoster_path()).into(imageView);
        }
    }
}
