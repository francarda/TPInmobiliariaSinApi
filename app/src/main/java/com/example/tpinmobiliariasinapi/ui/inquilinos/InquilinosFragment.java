package com.example.tpinmobiliariasinapi.ui.inquilinos;

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
import com.example.tpinmobiliariasinapi.databinding.FragmentSlideshowBinding;
import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.ui.inmubles.InmuebleAdapter;
import com.example.tpinmobiliariasinapi.ui.inmubles.SlideshowViewModel;

import java.util.List;

public class InquilinosFragment extends Fragment {

    private FragmentInquilinosBinding binding;
    private RecyclerView rv;
    private InquilinosViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(InquilinosViewModel.class);

        binding = FragmentInquilinosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMlista().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                rv= getActivity().findViewById(R.id.rvInquilinos);
                GridLayoutManager gl= new GridLayoutManager(getActivity(), inmuebles.size(),GridLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(gl);
                InquilinoAdaptador ia= new InquilinoAdaptador(inmuebles, getActivity(), getLayoutInflater());
                rv.setAdapter(ia);

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