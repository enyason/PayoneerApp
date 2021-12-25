package com.enyason.payoneerapp.common.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.enyason.payoneerapp.databinding.LayoutForErrorDialogBinding;

public class ErrorDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutForErrorDialogBinding binding = LayoutForErrorDialogBinding.inflate(inflater);
        String errorMessage = ErrorDialogFragmentArgs.fromBundle(getArguments()).getMessage();
        binding.errorMsg.setText(errorMessage);
        return binding.getRoot();
    }
}
