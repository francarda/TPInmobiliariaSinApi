package com.example.tpinmobiliariasinapi.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.databinding.FragmentContratoDetalleBinding;
import com.example.tpinmobiliariasinapi.databinding.FragmentInquilinoDetalleBinding;
import com.example.tpinmobiliariasinapi.model.Contrato;
import com.example.tpinmobiliariasinapi.model.Inquilino;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoDetalle;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoDetalleViewModel;

public class ContratoDetalle extends Fragment {

    private ContratoDetalleViewModel mViewModel;

    public static ContratoDetalle newInstance() {
        return new ContratoDetalle();
    }

    private ContratoDetalleViewModel vm;
    private FragmentContratoDetalleBinding binding;
    private Contrato contratoActual;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        vm= new ViewModelProvider(this).get(ContratoDetalleViewModel.class);
        binding = FragmentContratoDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMInquilino().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
               contratoActual= contrato;
                binding.tvFechaFinalizacion.setText(contrato.getFechaFin());
                binding.tvFechaInicio.setText(contrato.getFechaInicio());
                binding.tvInmuebleC.setText(contrato.getInmueble().getDireccion());
                binding.tvIdContrato.setText(contrato.getIdContrato()+"");
                binding.tvMontoAlquiler.setText("$"+ contrato.getMontoAlquiler());
                binding.tvInquilinoC.setText(contrato.getInquilino().getNombre()+" " + contrato.getInquilino().getApellido());


            }
        });
        binding.btPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle= new Bundle();
                bundle.putSerializable("Contrato", contratoActual);
                //bundle.putSerializable("nota", "algo");
                // tengo que crear ese fragment
                Navigation.findNavController(view).navigate(R.id.pagoFragment, bundle);
            }
        });
        Bundle bundle= getArguments();
        vm.cargarContrato(bundle);




        return root;
    }


}
