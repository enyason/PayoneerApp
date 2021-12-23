package com.enyason.payoneerapp.presentation.paymentmethods;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentMethodsAdapter extends ListAdapter<PaymentMethodsAdapter.ViewHolder> {


    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
