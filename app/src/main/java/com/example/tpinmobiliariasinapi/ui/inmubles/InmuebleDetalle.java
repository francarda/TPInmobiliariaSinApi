package com.example.tpinmobiliariasinapi.ui.inmubles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.databinding.FragmentInmuebleDetalleBinding;
import com.example.tpinmobiliariasinapi.model.Inmueble;

public class InmuebleDetalle extends Fragment {

    private InmuebleDetalleViewModel vm;
    private FragmentInmuebleDetalleBinding binding;
    private Inmueble inmuebleSelec;

    public static InmuebleDetalle newInstance() {
        return new InmuebleDetalle();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm= new ViewModelProvider(this).get(InmuebleDetalleViewModel.class);
       binding = FragmentInmuebleDetalleBinding.inflate(inflater, container, false);
       View root = binding.getRoot();

       vm.getMInmueble().observe(getActivity(), new Observer<Inmueble>() {
           @Override
           public void onChanged(Inmueble inmueble) {
               inmuebleSelec= inmueble;
               binding.tvDICodigo.setText(inmueble.getIdInmueble()+"");
               binding.tvDIAmbientes.setText(inmueble.getAmbientes()+"");
               binding.tvDIDireccion.setText(inmueble.getDireccion());
               binding.tvDIPrecio.setText(inmueble.getPrecio()+"");
               binding.tvDITipo.setText(inmueble.getTipo());
               binding.tvDIUso.setText(inmueble.getUso());
               binding.cbDisponible.setChecked(inmueble.isEstado());
               //binding.cbDisponible.setEnabled(false);
               String nombreImagen="casa_" + inmueble.getIdInmueble();
               int idImagen = requireContext().getResources().getIdentifier(nombreImagen, "drawable", requireContext().getPackageName());
               binding.imagenInmuebleDetalle.setImageResource(idImagen);

           }
       });
       binding.cbDisponible.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               CheckBox cb= (CheckBox) view;
               vm.editarDisponible(cb.isChecked(), getContext());
           }
       });
        Bundle bundle= getArguments();
        vm.cargarInmueble(bundle);

        return root;

    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm= new ViewModelProvider(this).get(InmuebleDetalleViewModel.class);
        // TODO: Use the ViewModel
    }*/

}

/*private FragmentSlideshowBinding binding;
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
                InmuebleAdapter ia= new InmuebleAdapter(inmuebles, getActivity(), getLayoutInflater());
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
}*/