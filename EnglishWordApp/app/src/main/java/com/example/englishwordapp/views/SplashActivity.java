package com.example.englishwordapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.englishwordapp.viewModels.MainViewModel;

public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(!isFinishing()) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}
