package com.example.englishwordapp.viewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.example.englishwordapp.databinding.FragmentFavoriteBinding;
import com.example.englishwordapp.databinding.FragmentSettingBinding;

public class SettingViewModel {

    private LayoutInflater layoutInflater;
    private Context context;

    private FragmentSettingBinding fragmentSettingBinding;

    private FragmentManager fragmentManager;

    private SettingViewModel(LayoutInflater layoutInflater, Context context) {
        this.layoutInflater = layoutInflater;
        this.context = context;

        this.fragmentSettingBinding = FragmentSettingBinding.inflate(layoutInflater);

        fragmentManager = MainViewModel.getInstance().getFragmentManager();

        fragmentSettingBinding.settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "SettingFragment!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static SettingViewModel getInstance(LayoutInflater layoutInflater, Context context) {
        return new SettingViewModel(layoutInflater, context);
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public Context getContext() {
        return context;
    }

    public FragmentSettingBinding getFragmentSettingBinding() {
        return fragmentSettingBinding;
    }
}
