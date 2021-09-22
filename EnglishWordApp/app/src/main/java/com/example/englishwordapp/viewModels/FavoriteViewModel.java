package com.example.englishwordapp.viewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.example.englishwordapp.databinding.FragmentFavoriteBinding;
import com.example.englishwordapp.databinding.FragmentHomeBinding;

public class FavoriteViewModel {

    private LayoutInflater layoutInflater;
    private Context context;

    private FragmentFavoriteBinding fragmentFavoriteBinding;

    private FragmentManager fragmentManager;

    private FavoriteViewModel(LayoutInflater layoutInflater, Context context) {
        this.layoutInflater = layoutInflater;
        this.context = context;

        this.fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater);

        fragmentManager = MainViewModel.getInstance().getFragmentManager();

        fragmentFavoriteBinding.favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "FavoriteFragment!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static FavoriteViewModel getInstance(LayoutInflater layoutInflater, Context context) {
        return new FavoriteViewModel(layoutInflater, context);
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public Context getContext() {
        return context;
    }

    public FragmentFavoriteBinding getFragmentFavoriteBinding() {
        return fragmentFavoriteBinding;
    }
}
