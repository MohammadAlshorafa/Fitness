package com.example.fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {
    ArrayList<Exercise> exercises;
    Context context;

    public ExercisesAdapter(ArrayList<Exercise> exercises, Context context) {
        this.exercises = exercises;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exercise_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercise e = exercises.get(position);
        holder.gifImageView.setImageResource(e.getGifImage());
//        Picasso.get().load(e.getGifImage()).fit().centerCrop().placeholder(R.drawable.ic_launcher_background).into(holder.gifImageView);
        holder.gifTitle.setText(e.getTitle());
        holder.gifCount.setText(e.getCount());

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        GifImageView gifImageView;
        TextView gifTitle, gifCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gifImageView = itemView.findViewById(R.id.gifImageView);
            gifTitle = itemView.findViewById(R.id.gif_title);
            gifCount = itemView.findViewById(R.id.gif_count);

        }
    }

}
