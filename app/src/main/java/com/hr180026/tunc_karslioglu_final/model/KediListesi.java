package com.hr180026.tunc_karslioglu_final.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KediListesi {


    public List<Kedi> getKediList() {
        return kediList;
    }

    public void setKediList(List<Kedi> kediList) {
        this.kediList = kediList;
    }

    @SerializedName("Kediler")
    private List<Kedi> kediList;
}
