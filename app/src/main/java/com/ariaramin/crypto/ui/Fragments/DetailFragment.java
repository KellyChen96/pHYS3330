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
import java