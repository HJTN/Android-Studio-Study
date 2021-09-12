package com.example.studytest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.studytest.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private SimpleTextAdapter adapter;
    private SimpleTextAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // RecyclerView parts
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new SimpleTextAdapter();
        recyclerView.setAdapter(adapter);

        // AppBar parts
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Event parts
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.editText.getText().toString();
                if(!text.equals("")) {
                    adapter.addItem(text);
                    adapter.notifyDataSetChanged();

                    binding.editText.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.Search);
        searchView = (SearchView) menuItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                searchAdapter = new SimpleTextAdapter();

                ArrayList<String> stored = adapter.getArrayList();
                for(int i = 0; i < stored.size(); i++) {
                    if (stored.get(i).contains(s))
                        searchAdapter.addItem(stored.get(i));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                return true;
            case R.id.Search:
                return true;
            case R.id.Settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()) {
            recyclerView.setAdapter(adapter);
            searchView.setIconified(true);
        }
        else
            super.onBackPressed();
    }
}