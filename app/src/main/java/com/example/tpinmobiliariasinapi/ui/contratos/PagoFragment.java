package com.example.tpinmobiliariasinapi.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.databinding.FragmentInquilinosBinding;
import com.example.tpinmobiliariasinapi.databinding.FragmentPagoBinding;
import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.model.Pago;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdaptador;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinosViewModel;

import java.util.List;

public class PagoFragment extends Fragment {

    private FragmentPagoBinding binding;
    private RecyclerView rv;
    private PagoViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(PagoViewModel.class);

        binding = FragmentPagoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMlista().observe(getViewLifecycleOwner(), new Observer<List<Pago>>() {
            @Override
            public void onChanged(List<Pago> pagos) {
                rv= getActivity().findViewById(R.id.rvPagos);
                GridLayoutManager gl= new GridLayoutManager(getActivity(), pagos.size(),GridLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(gl);
                PagoAdapter pa= new PagoAdapter(pagos, getActivity(), getLayoutInflater());
                rv.setAdapter(pa);

            }
        });
        Bundle bundle= getArguments();
        vm.cargarLista(bundle);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}