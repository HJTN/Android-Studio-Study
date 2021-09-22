package com.example.englishwordapp.viewModels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishwordapp.adapter.WordsAdapter;
import com.example.englishwordapp.databinding.ActivityWordsBinding;
import com.example.englishwordapp.dtos.DtoWords;
import com.example.englishwordapp.handlers.GetWordsCallBack;
import com.example.englishwordapp.utils.FirebaseWordsUtils;

import java.util.ArrayList;

public class WordsViewModel {
    private static WordsViewModel wordsViewModel;

    private ActivityWordsBinding activityWordsBinding;
    private LayoutInflater layoutInflater;
    private Context context;
    private AppCompatActivity appCompatActivity;

    private RecyclerView recyclerView;
    private WordsAdapter adapter;

    public WordsViewModel(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
        this.activityWordsBinding = ActivityWordsBinding.inflate(layoutInflater);

        recyclerView = activityWordsBinding.wordsRVPlace;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));

        FirebaseWordsUtils.getWord(appCompatActivity.getIntent().getStringExtra("WordSheet"), new GetWordsCallBack() {
            @Override
            public void handle(ArrayList<DtoWords> result) {
                adapter = new WordsAdapter(result);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public static WordsViewModel getInstance(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        wordsViewModel = new WordsViewModel(layoutInflater, context, appCompatActivity);
        return wordsViewModel;
    }

    public static WordsViewModel getInstance() {
        return wordsViewModel;
    }

    public ActivityWordsBinding getActivityWordsBinding() {
        return activityWordsBinding;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public Context getContext() {
        return context;
    }

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }
}
