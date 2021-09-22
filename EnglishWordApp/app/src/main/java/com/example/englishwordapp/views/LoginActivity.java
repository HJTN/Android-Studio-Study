package com.example.englishwordapp.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishwordapp.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new LoginViewModel(getLayoutInflater(),getApplicationContext(), LoginActivity.this);
        setContentView(loginViewModel.getActivityLoginBinding().getRoot());
    }
}