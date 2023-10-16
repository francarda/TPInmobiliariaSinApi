package com.example.tpinmobiliariasinapi.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.databinding.FragmentContratoBinding;
import com.example.tpinmobiliariasinapi.databinding.FragmentInquilinosBinding;
import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdaptador;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinosViewModel;

import java.util.List;

public class ContratoFragment extends Fragment {

    private FragmentContratoBinding binding;
    private RecyclerView rv;
    private ContratoViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(ContratoViewModel.class);

        binding = FragmentContratoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMlista().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                rv= getActivity().findViewById(R.id.rvContratos);
                LinearLayoutManager ll= new LinearLayoutManager(getActivity());
               // GridLayoutManager gl= new GridLayoutManager(getActivity(), inmuebles.size(),GridLayoutManager.HORIZONTAL, false);
                //rv.setLayoutManager(gl);
                ContratoAdapter ca= new ContratoAdapter(inmuebles, getActivity(), getLayoutInflater());
                rv.setLayoutManager(ll);
                rv.setAdapter(ca);

            }
        });
        vm.cargarLista();




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}