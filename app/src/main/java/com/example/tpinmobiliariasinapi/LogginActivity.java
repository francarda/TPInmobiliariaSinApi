package com.example.tpinmobiliariasinapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tpinmobiliariasinapi.databinding.ActivityLogginBinding;

public class LogginActivity extends AppCompatActivity {

    private ActivityLogginBinding binding;
    private LogginActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LogginActivityViewModel.class);
        binding = ActivityLogginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
    public void cargarPermisos(){

    }
}