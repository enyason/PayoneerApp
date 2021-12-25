package com.enyason.payoneerapp.presentation.paymentmethods;

import static com.enyason.payoneerapp.LiveDataTestUtil.getOrAwaitValue;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.enyason.payoneerapp.TestScheduler;
import com.enyason.payoneerapp.common.Result;
import com.enyason.payoneerapp.common.Scheduler;
import com.enyason.payoneerapp.core.domain.PaymentMethod;
import com.enyason.payoneerapp.core.domain.usecases.GetPaymentMethods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class PaymentMethodsViewModelTest {


    @Mock
    GetPaymentMethods getPaymentMethods;

    private final Scheduler scheduler = new TestScheduler();

    private PaymentMethodsViewModel sut;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        sut = new PaymentMethodsViewModel(getPaymentMethods, scheduler);
    }

    @Test
    public void WHEN_GettingPaymentMethodsIsSuccessful_THEN_returnPaymentMethods() throws InterruptedException {
        List<PaymentMethod> items = getTestPaymentMethods();

        Mockito.when(getPaymentMethods.execute()).thenReturn(Single.just(items));

        sut.getPaymentMethods();

        Mockito.verify(getPaymentMethods).execute();
        Assert.assertEquals(items, getOrAwaitValue(sut.paymentMethodsObserver()).getData());
        Assert.assertEquals(items.get(0).getId(), getOrAwaitValue(sut.paymentMethodsObserver()).getData().get(0).getId());
        Assert.assertEquals(items.size(), getOrAwaitValue(sut.paymentMethodsObserver()).getData().size());
    }

    @Test
    public void WHEN_GettingPaymentMethods_THEN_verifyLoadingStates() throws InterruptedException {
        List<PaymentMethod> items = getTestPaymentMethods();
        Observer<Boolean> loadingObserver = Mockito.mock(Observer.class);
        sut.loadingObserver().observeForever(loadingObserver);

        Mockito.when(getPaymentMethods.execute()).thenReturn(Single.just(items));

        sut.getPaymentMethods();

        Mockito.verify(loadingObserver).onChanged(true);
        Mockito.verify(loadingObserver).onChanged(false);
    }

    @Test
    public void GIVEN_NoInternet_WHEN_GettingPaymentMethods_THEN_returnErrorIOException() throws InterruptedException {
        String errorMsg = "We can not establish connection with server, please turn on WIFI an try again";
        ArgumentCaptor<Result<List<PaymentMethod>>> captor = ArgumentCaptor.forClass(Result.class);
        Observer<Result<List<PaymentMethod>>> resultObserver = Mockito.mock(Observer.class);
        sut.paymentMethodsObserver().observeForever(resultObserver);

        Mockito.when(getPaymentMethods.execute()).thenReturn(Single.error(new IOException()));

        sut.getPaymentMethods();

        Mockito.verify(resultObserver).onChanged(captor.capture());
        Assert.assertNull(captor.getValue().getData());
        Assert.assertNotNull(captor.getValue().getMessage());
        Assert.assertEquals(captor.getValue().getMessage(), errorMsg);
    }


    private List<PaymentMethod> getTestPaymentMethods() {
        List<PaymentMethod> list = new ArrayList<>();
        list.add(new PaymentMethod("AMEX", "American Express", ""));
        list.add(new PaymentMethod("MASTERCARD", "MASTERCARD", ""));
        list.add(new PaymentMethod("VISA", "VISA", ""));
        return list;
    }


}