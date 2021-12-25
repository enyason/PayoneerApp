package com.enyason.payoneerapp.presentation.di;

import com.enyason.payoneerapp.core.domain.usecases.GetPaymentMethods;
import com.enyason.payoneerapp.core.domain.usecases.GetPaymentMethodsImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public abstract class PaymentModule {

    @Binds
    public abstract GetPaymentMethods bindGetPaymentMethods(GetPaymentMethodsImpl getPaymentMethodsImpl);
}
