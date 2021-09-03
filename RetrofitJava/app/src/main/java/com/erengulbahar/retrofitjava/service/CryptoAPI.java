package com.erengulbahar.retrofitjava.service;

import com.erengulbahar.retrofitjava.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI
{
    //GET, POST, UPDATE, DELETE
    //URL BASE -> www.website.com
    //GET -> price?key=xxx

    @GET("YOUR_API_KEY")
    Observable<List<CryptoModel>> getData();

    //Call<List<CryptoModel>> getData();
}