package com.example.englishwordapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.englishwordapp.viewModels.WordsViewModel;

public class WordsActivity extends AppCompatActivity {
    private WordsViewModel wordsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        wordsViewModel = WordsViewModel.getInstance(getLayoutInflater(),getApplicationContext(), WordsActivity.this);
        setContentView(wordsViewModel.getActivityWordsBinding().getRoot());
    }
}