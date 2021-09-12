package com.example.appbarstudy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 위로 버튼 사용 설정정
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        //getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        searchView = (SearchView) searchItem.getActionView();
        // 검색 버튼 클릭 시, SearchView 길이 꽉차게 늘려주기
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
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
            case R.id.actionSettings:
                Toast.makeText(this, "Setting selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionFavorite:
                Toast.makeText(this, "Like button clicked!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionSearch:
                Toast.makeText(this, "Search button clicked", Toast.LENGTH_SHORT).show();
            default:
                Toast.makeText(this, "Click again!!", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }

    // 뒤로가기 버튼 클릭 시, SearchView 종료
    @Override
    public void onBackPressed() {
        if(!searchView.isIconified())
            searchView.setIconified(true);
        else
            super.onBackPressed();
    }
}