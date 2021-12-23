package com.enyason.payoneerapp.core.domain.usecases;

import com.enyason.payoneerapp.core.domain.Result;

interface GetPaymentMethods {
    Result<String> execute();
}


class GetPaymentMethodsImpl implements GetPaymentMethods {

    @Override
    public Result<String> execute() {
        return Result.success("");
    }
}
