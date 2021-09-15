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
    private SimpleTextAdapter madapter;
    private SimpleTextAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // RecyclerView parts
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        madapter = new SimpleTextAdapter();
        sAdapter = new SimpleTextAdapter();
        recyclerView.setAdapter(madapter);

        // AppBar parts
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Event parts
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.editText.getText().toString();
                if(!text.equals("")) {
                    madapter.addItemTomData(text);
                    madapter.notifyDataSetChanged();

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

                /*for(int i = 0; i < madapter.getItemCount(); i++) {
                    if (madapter.getmData().get(i).contains(s))
                        sAdapter.addItemTomData(madapter.getmData().get(i));
                }
                recyclerView.setAdapter(sAdapter);*/
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                sAdapter.clearmData();
                for(int i = 0; i < madapter.getItemCount(); i++) {
                    if (madapter.getmData().get(i).contains(s))
                        sAdapter.addItemTomData(madapter.getmData().get(i));
                }
                recyclerView.setAdapter(sAdapter);
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
            searchView.setIconified(true);
        }
        else
            super.onBackPressed();
    }
}