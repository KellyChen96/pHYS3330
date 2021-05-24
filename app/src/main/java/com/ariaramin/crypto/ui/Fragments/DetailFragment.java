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
        String percentageChange30 = String.format("%.2f", dataItem.getListQuote().get(0).getP