package com.enyason.payoneerapp.presentation.paymentmethods;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.enyason.payoneerapp.core.domain.PaymentMethod;
import com.enyason.payoneerapp.databinding.LayoutForPaymentMethodBinding;
import com.squareup.picasso.Picasso;

public class PaymentMethodsAdapter extends ListAdapter<PaymentMethod, PaymentMethodsAdapter.ViewHolder> {

    protected PaymentMethodsAdapter() {
        super(PaymentMethod.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutForPaymentMethodBinding binding = LayoutForPaymentMethodBinding.inflate(inflater);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(getItem(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final LayoutForPaymentMethodBinding binding;

        public ViewHolder(@NonNull LayoutForPaymentMethodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(PaymentMethod model) {
            binding.name.setText(model.getName());
            Picasso.get().load(model.getLogo()).into(binding.icon);
        }
    }
}
