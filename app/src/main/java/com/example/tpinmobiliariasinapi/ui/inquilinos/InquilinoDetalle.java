package com.example.tpinmobiliariasinapi.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tpinmobiliariasinapi.databinding.FragmentInquilinoDetalleBinding;
import com.example.tpinmobiliariasinapi.model.Inquilino;


public class InquilinoDetalle extends Fragment {

    private InquilinoDetalleViewModel vm;
    private FragmentInquilinoDetalleBinding binding;
    private Inquilino inquilinoactual;

    public static InquilinoDetalle newInstance() {
        return new InquilinoDetalle();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        vm= new ViewModelProvider(this).get(InquilinoDetalleViewModel.class);
        binding = FragmentInquilinoDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMInquilino().observe(getViewLifecycleOwner(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                inquilinoactual= inquilino;
                binding.tvApellidoI.setText(inquilino.getApellido());
                binding.tvCodigoI.setText(inquilino.getIdInquilino()+"");
                binding.tvDniI.setText(inquilino.getDNI()+"");
                binding.tvEmailI.setText(inquilino.getEmail());
                binding.tvGaranteI.setText(inquilino.getNombreGarante());
                binding.tvTelGaranteI.setText(inquilino.getTelefonoGarante());
                binding.tvNombreI.setText(inquilino.getNombre());
                binding.tvTelefonoI.setText(inquilino.getTelefono());

            }
        });

        Bundle bundle= getArguments();
        vm.cargarInquilino(bundle);




        return root;
    }


}