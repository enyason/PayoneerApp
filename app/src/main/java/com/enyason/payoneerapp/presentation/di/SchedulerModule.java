package com.enyason.payoneerapp.presentation.di;


import com.enyason.payoneerapp.common.Scheduler;
import com.enyason.payoneerapp.presentation.AppScheduler;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class SchedulerModule {

    @Binds
    public abstract Scheduler bindScheduler(AppScheduler appScheduler);
}