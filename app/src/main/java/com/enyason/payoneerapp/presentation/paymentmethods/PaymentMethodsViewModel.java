package com.enyason.payoneerapp.presentation.paymentmethods;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.enyason.payoneerapp.common.Scheduler;
import com.enyason.payoneerapp.core.domain.PaymentMethod;
import com.enyason.payoneerapp.core.domain.usecases.GetPaymentMethods;
import com.enyason.payoneerapp.common.ErrorUtils;
import com.enyason.payoneerapp.common.Result;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;

import javax.inject.Inject;

@HiltViewModel
public class PaymentMethodsViewModel extends ViewModel {

    private final Scheduler scheduler;
    private final GetPaymentMethods getPaymentMethods;

    private final CompositeDisposable container = new CompositeDisposable();

    private final MutableLiveData<Result<List<PaymentMethod>>> _paymentMethods = new MutableLiveData<>();

    public LiveData<Result<List<PaymentMethod>>> paymentMethodsObserver() {
        return _paymentMethods;
    }

    @Inject
    PaymentMethodsViewModel(GetPaymentMethods getPaymentMethods, Scheduler scheduler) {
        this.getPaymentMethods = getPaymentMethods;
        this.scheduler = scheduler;
    }

    public void getPaymentMethods() {
        Disposable disposable = getPaymentMethods
                .execute()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.main())
                .doOnError(throwable -> {
                    String message = ErrorUtils.extractErrorMessage(throwable);
                    _paymentMethods.postValue(Result.error(message));
                }).doOnSuccess(paymentMethods -> {
                    _paymentMethods.postValue(Result.success(paymentMethods));
                }).subscribe();

        container.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        container.clear();
    }
}
