package com.enyason.payoneerapp.core.api;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface PayoneerApi {
    //    https://raw.githubusercontent.com
    @GET("/optile/checkout-android/develop/shared-test/lists/listresult.json")
    Single<PaymentMethodsResponse> getPaymentMethods();

}
