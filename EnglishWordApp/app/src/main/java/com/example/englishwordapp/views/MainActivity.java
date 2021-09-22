package com.example.englishwordapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.example.englishwordapp.R;
import com.example.englishwordapp.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModel = MainViewModel.getInstance(getLayoutInflater(),getApplicationContext(),MainActivity.this);
        setContentView(mainViewModel.getActivityMainBinding().getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        mainViewModel.showDialog(this);
    }
}