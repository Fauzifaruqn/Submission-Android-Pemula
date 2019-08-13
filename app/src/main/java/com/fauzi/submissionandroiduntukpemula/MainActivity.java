package com.fauzi.submissionandroiduntukpemula;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSinger;
    private ArrayList<Singer> list ;
//        new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSinger = findViewById(R.id.rv_singer);
        rvSinger.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(SingerData.getListData());


        showRecyclerCard();
    }

    private void showRecyclerCard() {
        rvSinger.setLayoutManager(new LinearLayoutManager(this));
        ListSingerAdapater listSingerAdapter = new ListSingerAdapater(this);
        listSingerAdapter.setListSinger(list);
        rvSinger.setAdapter(listSingerAdapter);
    }

//    private void setActionBarTitle(String title){
//        getSupportActionBar().setTitle(title);
//    }
    private void showAbout(){
        rvSinger.setLayoutManager(new LinearLayoutManager(this));
        Intent pindahAbout = new Intent(MainActivity.this,About.class);
        startActivity(pindahAbout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title = null;

        switch (item.getItemId()) {
            case R.id.action_about:
//                title = "About Me";
                showAbout();
                break;

            case R.id.action_cardview:
//                title = "List Penyanyi";
                showRecyclerCard();
                break;
        }
//        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }
}
