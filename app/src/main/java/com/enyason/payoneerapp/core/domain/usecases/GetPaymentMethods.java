package com.enyason.payoneerapp.core.domain.usecases;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.enyason.payoneerapp.core.api.PayoneerApi;
import com.enyason.payoneerapp.core.domain.PaymentMethod;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.core.Single;




public interface GetPaymentMethods {
    Single<List<PaymentMethod>> execute();
}


