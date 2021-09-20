package com.example.englishwordapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishwordapp.viewModel.LoginViewModel;
import com.example.englishwordapp.viewModel.MainViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new LoginViewModel(getLayoutInflater(),getApplicationContext(), LoginActivity.this);
        setContentView(loginViewModel.getActivityLoginBinding().getRoot());
    }
}