package com.example.englishwordapp.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.englishwordapp.viewModels.FavoriteViewModel;
import com.example.englishwordapp.viewModels.HomeViewModel;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel favoriteViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favoriteViewModel = FavoriteViewModel.getInstance(getLayoutInflater(), getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return favoriteViewModel.getFragmentFavoriteBinding().getRoot();
    }
}
