package com.hr180026.tunc_karslioglu_final.ui.splash;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;

import com.hr180026.tunc_karslioglu_final.Constants;
import com.hr180026.tunc_karslioglu_final.R;
import com.hr180026.tunc_karslioglu_final.ui.ListeEkrani;

public class SplashEkrani extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        timerBaslat();

    }

    Context mContext;
    private boolean baslat=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ekrani);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        mContext=this;
        timerBaslat();
    }

    private void ekranGecisiYap(){
        if(baslat==false){
            startActivity(new Intent(SplashEkrani.this, ListeEkrani.class));
            finish();
            baslat=true;
        }

    }
    private void timerBaslat() {

        new CountDownTimer(Constants.SURE, Constants.SANIYE) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                if (internetKontrol()==true){
                    ekranGecisiYap();
                }
                else{
                   dialogGoster();

                }
            }
        }.start();
    }

    private void internetAc() {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(intent);
    }

    private boolean internetKontrol(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();

    }

    private void dialogGoster(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
        builder1.setMessage(R.string.internetbagla);
        builder1.setTitle(R.string.baglantıyok);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                R.string.internetac,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        internetAc();
                    }
                });

        builder1.setNegativeButton(
                R.string.kapat,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


}