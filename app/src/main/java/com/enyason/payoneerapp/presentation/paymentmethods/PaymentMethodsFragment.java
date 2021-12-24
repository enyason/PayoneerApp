package com.enyason.payoneerapp.presentation.paymentmethods;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PaymentMethodsAdapter adapter = new PaymentMethodsAdapter();
        binding.paymentMethodListView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.paymentMethodListView.setAdapter(adapter);
    }
}