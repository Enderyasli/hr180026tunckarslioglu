package com.hr180026.tunc_karslioglu_final.api;


import com.hr180026.tunc_karslioglu_final.model.KediListesi;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;


public interface IKediler {

    @GET("Kediler.json")
    Single<KediListesi> kedilerAl();
}
