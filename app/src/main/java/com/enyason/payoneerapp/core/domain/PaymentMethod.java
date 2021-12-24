package com.enyason.payoneerapp.core.domain;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod {
    private String id;
    private String name;
    private String logo;

    public PaymentMethod(String id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

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
