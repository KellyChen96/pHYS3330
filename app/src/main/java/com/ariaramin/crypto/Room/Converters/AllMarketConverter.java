
package com.ariaramin.crypto.Room.Converters;


import androidx.room.TypeConverter;

import com.ariaramin.crypto.Models.AllMarket;
import com.google.gson.Gson;

public class AllMarketConverter {

    @TypeConverter
    public String toJson(AllMarket allMarket) {
        Gson gson = new Gson();