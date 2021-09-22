package com.example.englishwordapp.viewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishwordapp.databinding.ActivityLoginBinding;
import com.example.englishwordapp.dtos.DtoUser;
import com.example.englishwordapp.utils.FirebaseUserDataUtils;

import java.util.HashMap;

public class LoginViewModel {
    private static LoginViewModel loginViewModel;

    private ActivityLoginBinding activityLoginBinding;
    private LayoutInflater layoutInflater;
    private Context context;
    private AppCompatActivity appCompatActivity;
    private FirebaseUserDataUtils login_FButil;

    private Integer userId = 1;

    public LoginViewModel(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
        this.activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater);

        login_FButil = new FirebaseUserDataUtils();

        activityLoginBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DtoUser dtoUser = new DtoUser(activityLoginBinding.etUserName.getText().toString(),
                        activityLoginBinding.etUserEmail.getText().toString());

                // Hashmap Create
                HashMap result = new HashMap<>();
                result.put("name",dtoUser.userName);
                result.put("email",dtoUser.email);

                login_FButil.setPost(userId, dtoUser);
                userId++;
            }
        });
    }

    public ActivityLoginBinding getActivityLoginBinding() {
        return activityLoginBinding;
    }

    public static LoginViewModel getInstance(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        loginViewModel = new LoginViewModel(layoutInflater, context, appCompatActivity);
        return loginViewModel;
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
