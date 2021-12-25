package com.enyason.payoneerapp;

import com.enyason.payoneerapp.common.Scheduler;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestScheduler implements Scheduler {

    @Override
    public io.reactivex.rxjava3.core.Scheduler io() {
        return Schedulers.trampoline();
    }

    @Override
    public io.reactivex.rxjava3.core.Scheduler main() {
        return Schedulers.trampoline();
    }
}
