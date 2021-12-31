package com.ariaramin.crypto.ui.Fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariaramin.crypto.Adapters.CurrencyAdapter;
import com.ariaramin.crypto.MainViewModel;
import com.ariaramin.crypto.Models.AllMarket;
import com.ariaramin.crypto.Models.DataItem;
import com.ariaramin.crypto.R;
import com.ariaramin.crypto.Room.Entities.AllMarketEntity;
import com.ariaramin.crypto.databinding.FragmentTopGainLoseBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.