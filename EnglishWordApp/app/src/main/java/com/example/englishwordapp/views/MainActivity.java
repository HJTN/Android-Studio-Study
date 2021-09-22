package com.example.englishwordapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import com.example.englishwordapp.R;
import com.example.englishwordapp.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModel = MainViewModel.getInstance(getLayoutInflater(),getApplicationContext(),MainActivity.this);
        setContentView(mainViewModel.getActivityMainBinding().getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toobar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.icSearch);
        searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, newText+"", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified())
            searchView.setIconified(true);
        else
            mainViewModel.showDialog(this);
    }
}