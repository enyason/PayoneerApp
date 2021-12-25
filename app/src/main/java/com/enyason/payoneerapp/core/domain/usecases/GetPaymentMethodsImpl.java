package com.enyason.payoneerapp.core.domain.usecases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.enyason.payoneerapp.core.api.PayoneerApi;
import com.enyason.payoneerapp.core.domain.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class GetPaymentMethodsImpl implements GetPaymentMethods {

    @Inject
    PayoneerApi api;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Single<List<PaymentMethod>> execute() {
        return api.getPaymentMethods()
                .map(paymentMethodsResponse -> paymentMethodsResponse.getNetworks().getApplicable())
                .map(applicables -> {
                            List<PaymentMethod> list = new ArrayList<>();
                            applicables.forEach(applicable -> list.add(new PaymentMethod(
                                    applicable.getCode(),
                                    applicable.getLabel(),
                                    applicable.getLinks().getLogo()
                            )));

                            return list;
                        }
                );
    }
}
