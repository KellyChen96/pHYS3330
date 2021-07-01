package com.ariaramin.crypto.ui.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.ariaramin.crypto.Adapters.DetailAdapter;
import com.ariaramin.crypto.MainActivity;
import com.ariaramin.crypto.Models.DataItem;
import com.ariaramin.crypto.R;
import com.ariaramin.crypto.databinding.FragmentDetailBinding;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DetailFragment extends Fragment {

    FragmentDetailBinding detailBinding;
    ArrayList<String> watchlist;
    Boolean watchlistIsChecked = false;
    MainActivity mainActivity;
    ArrayList<String> detailKeysArray;
    ArrayList<String> detailValuesArray;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        detailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        Bundle args = getArguments();
        DataItem dataItem = args.getParcelable("Coin");
        mainActivity.smoothBottomBar.setVisibility(View.GONE);
        detailBinding.backStackButton.setOnClickListener(v -> requireActivity().onBackPressed());

        setupDetail(dataItem);
        readData();
        addToWatchlist(dataItem);
        loadChart(dataItem);
        setButtonsClickListener(dataItem);
        setupDetailRecyclerView(dataItem);
        return detailBinding.getRoot();
    }

    private void setupDetailRecyclerView(DataItem dataItem) {
        fillDetailKeys();
        fillDetailValues(dataItem);
        DetailAdapter detailAdapter = new DetailAdapter(detailKeysArray, detailValuesArray);
        detailBinding.detailRecyclerView.setAdapter(detailAdapter);
    }

    private void fillDetailValues(DataItem dataItem) {
        detailValuesArray = new ArrayList<>();

        String marketCap = dataItem.getListQuote().get(0).getMarketCap().toString().split("\\.")[0];
        String volume24 = dataItem.getListQuote().get(0).getVolume24h().toString().split("\\.")[0];
        String dominance = String.format("%.2f", dataItem.getListQuote().get(0).getDominance());
        String percentageChange7 = String.format("%.2f", dataItem.getListQuote().get(0).getPercentChange7d());
        String percentageChange30 = String.format("%.2f", dataItem.getListQuote().get(0).getPercentChange30d());
        String high24 = setDecimal(dataItem.getHigh24h());
        String low24 = setDecimal(dataItem.getLow24h());
        String ath = setDecimal(dataItem.getAth());
        String atl = setDecimal(dataItem.getAtl());
        String totalSupply = dataItem.getTotalSupply().toString().split("\\.")[0];

        detailValuesArray.add(dataItem.getName());
        detailValuesArray.add("$" + marketCap);
        detailValuesArray.add("$" + volume24);
        detailValuesArray.add(dominance);
        detailValuesArray.add(percentageChange7);
        detailValuesArray.add(percentageChange30);
        detailValuesArray.add(high24);
        detailValuesArray.add(low24);
        detailValuesArray.add(ath);
        detailValuesArray.add(atl);
        detailValuesArray.add(totalSupply);
    }

    private String setDecimal(double price) {
        if (price < 1) {
            return String.format("$%.8f", price);
        } else if (price < 10) {
            return String.format("$%.6f", price);
        } else {
            return String.format("$%.4f", price);
        }
    }

    private void fillDetailKeys() {
        detailKeysArray = new ArrayList<>();

        detailKeysArray.add("Name");
        detailKeysArray.add("Market Cap");
        detailKeysArray.add("Volume 24h");
        detailKeysArray.add("Dominance");
        detailKeysArray.add("PercentChange 7d");
        detailKeysArray.add("PercentChange 30d");
        detailKeysArray.add("High 24h");
        detailKeysArray.add("Low 24h");
        detailKeysArray.add("All Time High");
        detailKeysArray.add("All Time Low");
        detailKeysArray.add("Total Supply");
    }

    private void setupDetail(DataItem dataItem) {
        detailBinding.detailSymbolTextView.setText(dataItem.getSymbol());
        loadCoinLogo(dataItem);
        setPriceDecimal(dataItem);
        setChange(dataItem);
    }

    private void loadCoinLogo(DataItem dataItem) {
        Glide.with(detailBinding.getRoot().getContext())
                .load("https://s2.coinmarketcap.com/static/img/coins/64x64/" + dataItem.getId() + ".png")
                .thumbnail(
                        Glide.with(detailBinding.getRoot().getContext())
                                .load(R.drawable.spinner))
                .into(detailBinding.detailImageView);
    }

    private void setPriceDecimal(DataItem dataItem) {
        if (dataItem.getListQuote().get(0).getPrice() < 1) {
            detailBinding.detailPriceTextView.setText(String.format("$%.8f", dataItem.getListQuote().get(0).getPrice()));
        } else if (dataItem.getListQuote().get(0).getPrice() < 10) {
            detailBinding.detailPriceTextView.setText(String.format("$%.6f", dataItem.getListQuote().get(0).getPrice()));
        } else {
            detailBinding.detailPriceTextView.setText(String.format("$%.4f", dataItem.getListQuote().get(0).getPrice()));
        }
    }

    private void setChange(DataItem dataItem) {
        if (dataItem.getListQuote().get(0).getPercentChange24h() < 0) {
            int red = detailBinding.getRoot().getContext().getResources().getColor(R.color.red);
            detailBinding.detailChangeTextView.setTextColor(red);
            detailBinding.detailChangeImageView.setImageResource(R.drawable.ic_caret_down);
            detailBinding.detailChangeTextView.setText(String.format("%.2f", dataItem.getListQuote().get(0).getPercentChange24h()) + "%");
        } else {
          