package com.enyason.payoneerapp.common;

import com.enyason.payoneerapp.common.Scheduler;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AppScheduler implements Scheduler {

    @Override
    public io.reactivex.rxjava3.core.Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public io.reactivex.rxjava3.core.Scheduler main() {
        return AndroidSchedulers.mainThread();
    }
}
