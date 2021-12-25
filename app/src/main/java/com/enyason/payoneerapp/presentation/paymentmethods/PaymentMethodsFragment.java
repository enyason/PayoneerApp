package com.enyason.payoneerapp.presentation.paymentmethods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.enyason.payoneerapp.databinding.PaymentMethodsFragmentBinding;
import com.enyason.payoneerapp.common.Result;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class PaymentMethodsFragment extends Fragment {

    private PaymentMethodsFragmentBinding binding;

    private PaymentMethodsViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = PaymentMethodsFragmentBinding.inflate(inflater);
        viewModel = new ViewModelProvider(this).get(PaymentMethodsViewModel.class);
        viewModel.getPaymentMethods();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PaymentMethodsAdapter adapter = new PaymentMethodsAdapter();
        binding.paymentMethodListView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.paymentMethodListView.setAdapter(adapter);

        viewModel.paymentMethodsObserver().observe(getViewLifecycleOwner(), result -> {
            if (result.getStatus() == Result.Status.SUCCESS) {
                adapter.submitList(result.getData());
            } else if (result.getStatus() == Result.Status.ERROR) {
                NavDirections directions = PaymentMethodsFragmentDirections.toErrorDialogFragment(result.getMessage());
                Navigation.findNavController(binding.getRoot()).navigate(directions);
            }
        });
    }
}