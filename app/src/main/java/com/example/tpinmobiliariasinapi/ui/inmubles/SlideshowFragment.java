package com.example.tpinmobiliariasinapi.ui.inmubles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.databinding.FragmentSlideshowBinding;
import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdapter;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private RecyclerView rv;
    private SlideshowViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getMlista().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                rv= getActivity().findViewById(R.id.rvInmuebles);
                GridLayoutManager gl= new GridLayoutManager(getActivity(), inmuebles.size(),GridLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(gl);
                InquilinoAdapter ia= new InquilinoAdapter(inmuebles, getActivity(), getLayoutInflater());
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