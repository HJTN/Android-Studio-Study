package com.example.englishwordapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.englishwordapp.R;
import com.example.englishwordapp.viewModel.MainViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModel = new MainViewModel(getLayoutInflater(),getApplicationContext(),MainActivity.this);
        setContentView(mainViewModel.getActivityMainBinding().getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toobar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.icSearch);
        searchView = (SearchView) searchItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icSearch:
                Toast.makeText(this, "SearchIcon Selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.icFavorite:
                Toast.makeText(this, "FavoriteIcon Selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.appbarSetting:
                Toast.makeText(this, "SettingButton pushed!", Toast.LENGTH_SHORT).show();
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