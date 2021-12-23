package com.enyason.payoneerapp.presentation.paymentmethods;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enyason.payoneerapp.databinding.PaymentMethodsFragmentBinding;


public class PaymentMethodsFragment extends Fragment {

    private PaymentMethodsFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = PaymentMethodsFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }
}