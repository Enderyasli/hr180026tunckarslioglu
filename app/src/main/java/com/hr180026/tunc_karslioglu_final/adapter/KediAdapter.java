package com.hr180026.tunc_karslioglu_final.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.hr180026.tunc_karslioglu_final.R;
import com.hr180026.tunc_karslioglu_final.model.Kedi;
import com.hr180026.tunc_karslioglu_final.ui.DetayEkrani;
import java.util.ArrayList;


public class KediAdapter extends RecyclerView.Adapter<KediAdapter.ViewHolder> {


    public KediAdapter(Activity context, ArrayList<Kedi> kediModel) {
        this.context = context;
        this.kediModel = kediModel;
    }

    Activity context;
    ArrayList<Kedi> kediModel;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kedi_item, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Kedi kedi = kediModel.get(position);

        holder.baslik.setText(kedi.getKediAdi());
        holder.renk.setText(kedi.getRenk());
        Glide.with(context).asBitmap().load(kedi.getResimUrl()).skipMemoryCache(true).into(holder.kedi);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetayEkrani.class);
                intent.putExtra("kedi", kedi);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return kediModel.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView baslik,renk;
        ImageView kedi;

        public ViewHolder(View view) {
            super(view);
            kedi = view.findViewById(R.id.image);
            baslik = view.findViewById(R.id.baslik);
            renk = view.findViewById(R.id.renk);




        }
    }
}
