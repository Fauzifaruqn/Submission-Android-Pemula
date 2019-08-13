package com.fauzi.submissionandroiduntukpemula;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSingerAdapater extends RecyclerView.Adapter<ListSingerAdapater.ListViewHolder> {

    private ArrayList<Singer> listSinger;
    private Context context;


    public ListSingerAdapater(Context context){

        this.context = context;
    }

    public ArrayList<Singer> getListSinger() {
        return listSinger;
    }

    public void setListSinger(ArrayList<Singer> listSinger) {

        this.listSinger = listSinger;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_singer, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Singer s = getListSinger().get(position);

//        final String namaSinger = singer.getName();
//        final String fromSinger = singer.getFrom();
//        final String photoSinger = singer.getPhoto();
//        final String birtSinger = singer.getBirth();
//        final String songSinger = singer.getSong();
//        final String awarSinger = singer.getAward();


//        Singer singer = listSinger.get(position);
        Glide.with(context)
                .load(s.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(s.getName());
        holder.tvFrom.setText(s.getFrom());
        holder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent detailSinger = new Intent(context, DetailSinger.class);
                detailSinger.putExtra(DetailSinger.EXTRA_NAMA, getListSinger().get(position).getName());
                detailSinger.putExtra(DetailSinger.EXTRA_DETAIL, getListSinger().get(position).getFrom());
                detailSinger.putExtra(DetailSinger.EXTRA_FOTO, getListSinger().get(position).getPhoto());
                detailSinger.putExtra(DetailSinger.EXTRA_BIRTH, getListSinger().get(position).getBirth());
                detailSinger.putExtra(DetailSinger.EXTRA_SONG, getListSinger().get(position).getSong());
                detailSinger.putExtra(DetailSinger.EXTRA_AWARD, getListSinger().get(position).getAward());

                context.startActivity(detailSinger);
            }
        }));


    }

    @Override
    public int getItemCount() {
        return getListSinger().size();
    }


    public void stratActivity(Intent intent){

    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        ImageView imgPhoto;
        TextView tvName, tvFrom;
        Button btnDetail;
//        Singer singer;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            btnDetail = itemView.findViewById(R.id.btn_detail_singer);
//            btnDetail.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(context, DetailSinger.class);
//            intent.putExtra("key", singer);
//            context.startActivity(intent);
//
//        }
    }
}
