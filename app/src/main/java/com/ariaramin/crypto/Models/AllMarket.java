package com.ariaramin.crypto.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllMarket {

    @SerializedName("data")
    private Data data;

    @SerializedName("status")
    private Status status;

    public Data getData(){
        return data;
    }

    public Status getStatus(){
        ret