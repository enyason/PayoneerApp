package com.enyason.payoneerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.enyason.payoneerapp.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}