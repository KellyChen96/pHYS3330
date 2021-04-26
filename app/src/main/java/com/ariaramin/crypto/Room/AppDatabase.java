package com.ariaramin.crypto.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.ariaramin.crypto.Room.Converters.AllMarketConverter;
import com.ariaramin.crypto.Room.Entities.AllMarketEntity;

@TypeConverters({AllMarketConverter.class})
@Database(entit