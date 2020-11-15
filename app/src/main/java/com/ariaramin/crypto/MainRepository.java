package com.ariaramin.crypto;

import android.util.Log;

import com.ariaramin.crypto.Models.AllMarket;
import com.ariaramin.crypto.Retrofit.RequestApi;
import com.ariaramin.crypto.Room.DatabaseDao;
import com.ariaramin.crypto.Room.Entities.AllMarketEntity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainRepository {

    RequestApi requestApi;
    DatabaseDao databaseDao;
    CompositeDisposable compositeDisp