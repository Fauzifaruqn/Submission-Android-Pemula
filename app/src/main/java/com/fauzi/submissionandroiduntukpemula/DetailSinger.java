package com.fauzi.submissionandroiduntukpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailSinger extends AppCompatActivity {

    public static final String EXTRA_FOTO = "extra_foto";
    public static final String EXTRA_SONG = "extra_song";
    public static final String EXTRA_AWARD = "extra_award";
    public static final String EXTRA_NAMA = "extra_name" ;
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_BIRTH = "extra_birth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_singer);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Singer singerDiterima = getIntent().getParcelableExtra("key");

        String namaPenyanyi = getIntent().getStringExtra(EXTRA_NAMA);
        String formPenyanyi = getIntent().getStringExtra(EXTRA_DETAIL);
        String birthPenyanyi = getIntent().getStringExtra(EXTRA_BIRTH);
        String songPenyanyi = getIntent().getStringExtra(EXTRA_SONG);
        String awardPenyanyi = getIntent().getStringExtra(EXTRA_AWARD);
        String imgPenyanyi = getIntent().getStringExtra(EXTRA_FOTO);

        ImageView imgSinger = findViewById(R.id.img_item_photo);
        TextView formSinger = findViewById(R.id.tv_item_from);
        TextView nameSinger = findViewById(R.id.tv_item_name);
        TextView birthSinger = findViewById(R.id.tv_item_birth);
        TextView songSinger = findViewById(R.id.tv_item_song);
        TextView awardSinger = findViewById(R.id.tv_item_award);


        formSinger.setText(formPenyanyi);
        nameSinger.setText(namaPenyanyi);
        birthSinger.setText(birthPenyanyi);
        songSinger.setText(songPenyanyi);
        awardSinger.setText(awardPenyanyi);

        Glide.with(DetailSinger.this)
                .load(imgPenyanyi)
                .apply(new RequestOptions().override(350, 550))
                .into(imgSinger);

//        Glide.with(this).load(singerDiterima.getPhoto()).override(350,550).into(holder.imgPhoto);


    }
}
