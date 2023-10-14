package com.example.tpinmobiliariasinapi.ui.inicio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.SupportMapFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMMapa().observe(getViewLifecycleOwner(), new Observer<HomeViewModel.MapaActual>() {
            @Override
            public void onChanged(HomeViewModel.MapaActual mapaActual) {
                //@SuppressLint("ResourceType") SupportMapFragment smf = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.layout.fragment_home);
                SupportMapFragment smf= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

                //@SuppressLint("ResourceType") SupportMapFragment smf=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.layout.fragment_home);
                smf.getMapAsync(mapaActual);
            }
        });
        vm.obtenerMapa();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}