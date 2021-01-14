package com.hr180026.tunc_karslioglu_final.api;

import com.hr180026.tunc_karslioglu_final.model.KediListesi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class GetApiObserver {

    IKediler kedilistesi = RetrofitInstance.kediListesiGetir();

    public void loadApi(DisposableSingleObserver<KediListesi> observer) {

        kedilistesi.kedilerAl()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
