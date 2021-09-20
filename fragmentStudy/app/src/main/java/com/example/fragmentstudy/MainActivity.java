package com.example.fragmentstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private int fragmentNum = 1;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AppBar parts
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Fragment parts
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentPlace, new FirstFragment());
        fragmentTransaction.commit();

        // BottomNavi parts
        BottomNavigationView mBottomNV = findViewById(R.id.bottomNV);
        mBottomNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.BNhome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentPlace,new FirstFragment()).commit();
                        return true;
                    case R.id.BNfavorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentPlace,new SecondFragment()).commit();
                        return true;
                    case R.id.BNsettings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentPlace,new ThirdFragment()).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.icSearch);
        searchView = (SearchView) searchItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query+"", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icSearch:
                Toast.makeText(this, "SearchIcon selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.icFavorite:
                Toast.makeText(this, "FavoriteIcon pushed.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.appbarSetting:
                Toast.makeText(this, "Settings...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified())
            searchView.setIconified(true);
        else
            super.onBackPressed();
    }
}