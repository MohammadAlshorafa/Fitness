package com.example.fitness.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fitness.BmiActivity;
import com.example.fitness.ExercisesActivity;
import com.example.fitness.R;
import com.example.fitness.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private CardView foodCard, exercisesCard, bmiCard, calCard;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        foodCard = view.findViewById(R.id.foodCard);
        exercisesCard = view.findViewById(R.id.exercisesCard);
        bmiCard = view.findViewById(R.id.bmiCard);
        calCard = view.findViewById(R.id.calCard);

        return view;
//
////        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodCard.setOnClickListener(v -> {
//            startActivity(new Intent(getContext(), Activity.class));
        });
        exercisesCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), ExercisesActivity.class));
        });
        bmiCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), BmiActivity.class));
        });
        calCard.setOnClickListener(v -> {
//            startActivity(new Intent(getContext(), Activity.class));
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}