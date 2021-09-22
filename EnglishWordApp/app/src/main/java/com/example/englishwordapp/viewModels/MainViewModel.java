package com.example.englishwordapp.viewModels;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;

import android.view.View;
import android.view.Window;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import com.example.englishwordapp.R;
import com.example.englishwordapp.databinding.ActivityMainBinding;
import com.example.englishwordapp.views.FavoriteFragment;
import com.example.englishwordapp.views.HomeFragment;
import com.example.englishwordapp.views.SettingFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainViewModel {
    private static MainViewModel mainViewModel;

    private ActivityMainBinding activityMainBinding;
    private LayoutInflater layoutInflater;
    private Context context;
    private AppCompatActivity appCompatActivity;
    private FragmentManager fragmentManager;

    public MainViewModel(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
        this.activityMainBinding = ActivityMainBinding.inflate(layoutInflater);

        this.fragmentManager = appCompatActivity.getSupportFragmentManager();

        // ToolBar parts...
        appCompatActivity.setSupportActionBar(activityMainBinding.toolbar);
        appCompatActivity.getSupportActionBar().setTitle(R.string.MainAppBar_name);
        activityMainBinding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.appbarSearch:
                        Toast.makeText(context, "SearchButton pushed!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.appbarSetting:
                        Toast.makeText(context, "SettingButton pushed!", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Fragment & BottomNV parts...
        fragmentManager.beginTransaction().add(R.id.fragmentPlace, new HomeFragment()).commit();
        activityMainBinding.bottomNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.BNhome:
                        fragmentManager.beginTransaction().replace(R.id.fragmentPlace, new HomeFragment()).commit();
                        return true;
                    case R.id.BNfavorite:
                        fragmentManager.beginTransaction().replace(R.id.fragmentPlace, new FavoriteFragment()).commit();
                        return true;
                    case R.id.BNsettings:
                        fragmentManager.beginTransaction().replace(R.id.fragmentPlace, new SettingFragment()).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public static MainViewModel getInstance(LayoutInflater layoutInflater, Context context, AppCompatActivity appCompatActivity) {
        mainViewModel = new MainViewModel(layoutInflater, context, appCompatActivity);
        return mainViewModel;
    }

    public static MainViewModel getInstance() {
        return mainViewModel;
    }
    public ActivityMainBinding getActivityMainBinding() {
        return activityMainBinding;
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

    public FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public void showDialog(AppCompatActivity appCompatActivity){
        Dialog dialog = new Dialog(appCompatActivity);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog_close);
        dialog.show();
        dialog.findViewById(R.id.Yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(appCompatActivity);
                System.exit(0);
            }
        });
        dialog.findViewById(R.id.No).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
