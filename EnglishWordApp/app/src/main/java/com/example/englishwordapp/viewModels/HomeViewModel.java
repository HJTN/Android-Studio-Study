package com.example.englishwordapp.viewModels;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishwordapp.adapter.WordSheetAdapter;
import com.example.englishwordapp.databinding.FragmentHomeBinding;
import com.example.englishwordapp.repositorys.RepositoryWordSheet;

public class HomeViewModel {

    private LayoutInflater layoutInflater;
    private Context context;

    private FragmentHomeBinding fragmentHomeBinding;

    private FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    private WordSheetAdapter adapter;

    private HomeViewModel(LayoutInflater layoutInflater, Context context) {
        this.layoutInflater = layoutInflater;
        this.context = context;

        this.fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater);

        fragmentManager = MainViewModel.getInstance().getFragmentManager();

        recyclerView = fragmentHomeBinding.homeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));

        RepositoryWordSheet repositoryWordSheet = new RepositoryWordSheet();
        adapter = new WordSheetAdapter(repositoryWordSheet.getWordSheets());
        recyclerView.setAdapter(adapter);
    }

    public static HomeViewModel getInstance(LayoutInflater layoutInflater, Context context) {
        return new HomeViewModel(layoutInflater, context);
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public Context getContext() {
        return context;
    }

    public FragmentHomeBinding getFragmentHomeBinding() {
        return fragmentHomeBinding;
    }
}
