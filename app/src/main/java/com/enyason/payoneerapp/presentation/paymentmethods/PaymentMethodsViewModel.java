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
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

@HiltViewModel
public class PaymentMethodsViewModel extends ViewModel {

    private final Scheduler scheduler;
    private final GetPaymentMethods getPaymentMethods;

    private final CompositeDisposable container = new CompositeDisposable();

    private final MutableLiveData<Result<List<PaymentMethod>>> paymentMethods = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public LiveData<Result<List<PaymentMethod>>> paymentMethodsObserver() {
        return paymentMethods;
    }

    public LiveData<Boolean> loadingObserver() {
        return loading;
    }

    @Inject
    PaymentMethodsViewModel(GetPaymentMethods getPaymentMethods, Scheduler scheduler) {
        this.getPaymentMethods = getPaymentMethods;
        this.scheduler = scheduler;
    }

    public void getPaymentMethods() {
        Disposable disposable = getPaymentMethods
                .execute()
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.main())
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .doOnTerminate(() -> loading.setValue(false))
                .doOnError(throwable -> {
                    String message = ErrorUtils.extractErrorMessage(throwable);
                    paymentMethods.postValue(Result.error(message));
                }).doOnSuccess(paymentMethodList -> paymentMethods.postValue(Result.success(paymentMethodList)))
                .subscribe();

        container.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        container.clear();
    }
}
