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
    private double ath;

    @SerializedName("atl")
    private double atl;

    @SerializedName("high24h")
    private double high24h;

    @SerializedName("low24h")
    private double low24h;

    @SerializedName("isActive")
    private int isActive;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("dateAdded")
    private String dateAdded;

    @SerializedName("quotes")
    private List<USD> listQuote;

    @SerializedName("slug")
    private String slug;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public int getCmcRank() {
        return cmcRank;
    }

    public int getNumMarketPairs() {
        return numMarketPairs;
    }

    public double getCirculatingSupply() {
        return circulatingSupply;
    }

    public Number getTotalSupply() {
        return totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public double getAth() {
        return ath;
    }

    public double getAtl() {
        return atl;
    }

    public double getHigh24h() {
        return high24h;
    }

    public double getLow24h() {
        return low24h;
    }

    public int getIsActive() {
        return isActive;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public List<USD> getListQuote() {
        return listQuote;
    }

    public String getSlug() {
        return slug;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.symbol);
        dest.writeString(this.lastUpdated);
        dest.writeInt(this.cmcRank);
        dest.writeInt(this.numMarketPairs);
        dest.writeDouble(this.circulatingSupply);
        dest.writeSerializable(this.totalSupply);
        dest.writeDouble(this.maxSupply);
        dest.writeDouble(this.ath);
        dest.writeDouble(this.atl);
    