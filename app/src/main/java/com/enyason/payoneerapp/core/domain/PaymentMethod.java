package com.enyason.payoneerapp.core.domain;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import lombok.Data;

@Data
public class PaymentMethod {
    String id;
    String name;
    String logo;


    public static DiffUtil.ItemCallback<PaymentMethod> DIFF_CALLBACK = new DiffUtil.ItemCallback<PaymentMethod>() {
        @Override
        public boolean areItemsTheSame(@NonNull PaymentMethod oldItem, @NonNull PaymentMethod newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull PaymentMethod oldItem, @NonNull PaymentMethod newItem) {
            return oldItem.equals(newItem);
        }
    };
}
