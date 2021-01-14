package com.hr180026.tunc_karslioglu_final.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hr180026.tunc_karslioglu_final.R;
import com.hr180026.tunc_karslioglu_final.model.Kedi;

public class DetayEkrani extends AppCompatActivity {

    Context context;
    ImageView detayImage;
    TextView baslik, detay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay_ekrani);

        context = this;
        detayImage = findViewById(R.id.detayImage);
        baslik = findViewById(R.id.detayBaslik);
        detay = findViewById(R.id.detay);

        detaylarıEkle();

    }

    @SuppressLint("SetTextI18n")
    private void detaylarıEkle() {
        Kedi kedi = (Kedi) getIntent().getSerializableExtra("kedi");

        Glide.with(context).asBitmap().load(kedi.getResimUrl()).into(detayImage);
        detay.setText(Html.fromHtml(kedi.getDetay()));
        baslik.setText(kedi.getKediAdi() + getString(R.string.kedisi));


    }

}