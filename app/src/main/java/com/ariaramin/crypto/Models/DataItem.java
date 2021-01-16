package com.ariaramin.crypto.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataItem implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("lastUpdated")
    private String lastUpdated;

    @SerializedName("cmc_rank")
    private int cmcRank;

    @SerializedName("marketPairCount")
    private int numMarketPairs;

    @SerializedName("circulatingSupply")
    private double circulatingSupply;

    @SerializedName("totalSupply")
    private Number totalSupply;

    @SerializedName("max_supply")
    private double maxSupply;

    @SerializedName("ath")
 