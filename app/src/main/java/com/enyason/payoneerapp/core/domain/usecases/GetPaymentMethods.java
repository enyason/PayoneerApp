package com.enyason.payoneerapp.core.domain.usecases;

import com.enyason.payoneerapp.core.domain.PaymentMethod;

import java.util.List;

import io.reactivex.rxjava3.core.Single;


public interface GetPaymentMethods {
    Single<List<PaymentMethod>> execute();
}


