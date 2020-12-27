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
        return status;
    }


    public static class Data{

        @SerializedName("cryptoCurrencyList")
        private List<DataItem> cryptoCurrencyList;

        @SerializedName("totalCount")
        private int totalCount;

        public List<DataItem> getCryptoCurrencyList() {
            return cryptoCurrencyList;
        }

        public int getTotalCount() {
            return totalCount;
        }
    }

    public static class Status{

        @SerializedName("timestamp")
        private String timestamp;

        @Serial