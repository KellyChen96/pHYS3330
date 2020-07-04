package com.ariaramin.crypto.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ariaramin.crypto.Models.DataItem;
import com.ariaramin.crypto.R;
import com.ariaramin.crypto.databinding.CurrencyItemLayoutBinding;
import com.ariaramin.crypto.ui.Fragments.HomeFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    List<DataItem> dataItems;
    String TAG;

    public CurrencyAdapter(String tag, List<DataItem> dataItems) {
        TAG = tag;
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CurrencyItemLayoutBinding currencyItemLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.currency_item_layout, parent, false);
        return new CurrencyViewHolder(currencyItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
        holder.bindData(TAG, dataItems.get(position));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public void updateList(List<DataItem> dataItemList) {
        dataItems = dataItemList;
        notifyDataSetChanged();
    }


  