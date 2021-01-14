package com.hr180026.tunc_karslioglu_final.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hr180026.tunc_karslioglu_final.R;
import com.hr180026.tunc_karslioglu_final.adapter.KediAdapter;
import com.hr180026.tunc_karslioglu_final.api.GetApiObserver;
import com.hr180026.tunc_karslioglu_final.model.Kedi;
import com.hr180026.tunc_karslioglu_final.model.KediListesi;


import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;

public class ListeEkrani extends AppCompatActivity {
    RecyclerView liste;
    private KediAdapter adapter;
    DisposableSingleObserver<KediListesi> kediObserver;
    ProgressBar progressBar;
    TextView bekleyin;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste = findViewById(R.id.listRecyclerview);
        progressBar = findViewById(R.id.progressbar);
        bekleyin = findViewById(R.id.bekleyin);
        context=this;
        loadingGoster(true);

        GetApiObserver getApiObserver = new GetApiObserver();
        kediObserver = getKediObserver();
        getApiObserver.loadApi(kediObserver);

    }


    private DisposableSingleObserver<KediListesi> getKediObserver() {

        return new DisposableSingleObserver<KediListesi>() {
            @Override
            public void onSuccess(@NonNull KediListesi kediListesi) {
                recyclerViewDoldur((ArrayList<Kedi>) kediListesi.getKediList());
                loadingGoster(false);
            }

            @Override
            public void onError(Throwable e) {
                loadingGoster(false);
                Log.d("gelenhata", e.getLocalizedMessage());
            }
        };
    }


    private void recyclerViewDoldur(ArrayList<Kedi> kediListesi) {

        adapter = new KediAdapter(ListeEkrani.this, kediListesi);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        liste.setItemAnimator(null);
        liste.setLayoutManager(manager);
        liste.setAdapter(adapter);
        liste.setHasFixedSize(true);


    }

    private void loadingGoster(boolean bekle) {
        if (bekle == true) {
            progressBar.setVisibility(View.VISIBLE);
            bekleyin.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            bekleyin.setVisibility(View.GONE);

        }

    }

    public void onBackPressed(){
        dialogGoster();

    }

    private void uygulamayıKapat(){

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        finishAffinity();
    }

    private void dialogGoster(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(R.string.uygulamayıKapat);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
               R.string.vazgec,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                R.string.kapat,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        uygulamayıKapat();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}