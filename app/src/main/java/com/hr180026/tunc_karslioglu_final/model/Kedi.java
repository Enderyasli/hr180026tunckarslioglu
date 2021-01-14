package com.hr180026.tunc_karslioglu_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Kedi implements Serializable {


    public String getKediAdi() {
        return kediAdi;
    }

    public void setKediAdi(String kediAdi) {
        this.kediAdi = kediAdi;
    }

    public String getTuy() {
        return tuy;
    }

    public void setTuy(String tuy) {
        this.tuy = tuy;
    }

    public String getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(String agirlik) {
        this.agirlik = agirlik;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    @SerializedName("KediAdi")
    @Expose
    String kediAdi;

    @SerializedName("Tuy")
    @Expose
    String tuy;

    @SerializedName("Agirlik")
    @Expose
    String agirlik;

    @SerializedName("Renk")
    @Expose
    String renk;

    @SerializedName("ResimUrl")
    @Expose
    String resimUrl;

    @SerializedName("Detay")
    @Expose
    String detay;

}
