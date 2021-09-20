package com.example.englishwordapp.viewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishwordapp.databinding.ActivityMainBinding;
import com.example.englishwordapp.dtos.DtoUser;
import com.example.englishwordapp.utils.FirebaseUtil;

import java.util.HashMap;

public class MainViewModel {
    private static MainViewModel mainViewModel;

    private ActivityMainBinding activityMainBinding;
    private LayoutInflater layoutInflater;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public MainViewModel(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
        this.activityMainBinding = ActivityMainBinding.inflate(layoutInflater);

        appCompatActivity.setSupportActionBar(activityMainBinding.toolbar);


    }

    public ActivityMainBinding getActivityMainBinding() {
        return activityMainBinding;
    }

    public static MainViewModel getInstance(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        mainViewModel = new MainViewModel(layoutInflater, context, appCompatActivity);
        return mainViewModel;
    }

    public LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public Context getContext() {
        return this.context;
    }

    public AppCompatActivity getAppCompatActivity() {
        return this.appCompatActivity;
    }
}
