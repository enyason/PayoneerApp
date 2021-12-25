package com.enyason.payoneerapp.common;

public interface Scheduler {
    io.reactivex.rxjava3.core.Scheduler io();
    io.reactivex.rxjava3.core.Scheduler main();

}
