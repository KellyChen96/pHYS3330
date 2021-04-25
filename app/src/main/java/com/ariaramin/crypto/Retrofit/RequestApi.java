package com.ariaramin.crypto.Retrofit;

import com.ariaramin.crypto.Models.AllMarket;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface RequestApi {

    @GET("cryptocurrency/listing?start=1&limit=500&sortBy=market_