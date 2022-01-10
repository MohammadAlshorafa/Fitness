package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Exercise e1 = new Exercise();
        e1.setGifImage(R.drawable.bench_dips);
        e1.setTitle("bench press");
        e1.setCount("15 x 4");

        Exercise e2 = new Exercise();
        e2.setGifImage(R.drawable.chest);
        e2.setTitle("bench press");
        e2.setCount("15 x 4");

        Exercise e3 = new Exercise();
        e3.setGifImage(R.drawable.push_up);
        e3.setTitle("bench press");
        e3.setCount("12 x 3");

        Exercise e4 = new Exercise();
        e4.setGifImage(R.drawable.pike_press_up);
        e4.setTitle("bench press");
        e4.setCount("12 x 3");

        Exercise e5 = new Exercise();
        e5.setGifImage(R.drawable.bench_dips);
        e5.setTitle("bench press");
        e5.setCount("15 x 4");

        Exercise e6 = new Exercise();
        e6.setGifImage(R.drawable.chest);
        e6.setTitle("bench press");
        e6.setCount("15 x 4");

        Exercise e7 = new Exercise();
        e7.setGifImage(R.drawable.push_up);
        e7.setTitle("bench press");
        e7.setCount("12 x 3");

        Exercise e8 = new Exercise();
        e8.setGifImage(R.drawable.pike_press_up);
        e8.setTitle("bench press");
        e8.setCount("12 x 3");

        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(e1);
        exercises.add(e2);
        exercises.add(e3);
        exercises.add(e4);
        exercises.add(e5);
        exercises.add(e6);
        exercises.add(e7);
        exercises.add(e8);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ExercisesAdapter adapter = new ExercisesAdapter(exercises, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

    }
}