package com.example.tpinmobiliariasinapi.ui.perfil;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpinmobiliariasinapi.databinding.FragmentGalleryBinding;
import com.example.tpinmobiliariasinapi.model.Propietario;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GalleryViewModel vm;
    private Propietario propietarioActual;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm= new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.etCodigo.setEnabled(false);
        binding.etCodigo.setFocusable(false);

        vm.getMPropietario().observe(getActivity(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {

                binding.etApellido.setText(propietario.getApellido());
                binding.etCodigo.setText(propietario.getId()+"");
                binding.etDni.setText(propietario.getDni() +"");
                binding.etEmail.setText(propietario.getEmail());
                binding.etNombre.setText(propietario.getNombre());
                binding.etTelefono.setText(propietario.getTelefono());
                binding.etPass.setText(propietario.getContraseña());
                binding.etCodigo.setEnabled(false);
                binding.etCodigo.setFocusable(false);
                propietarioActual= propietario;

            }
        });
        Bundle bundle= (Bundle) getActivity().getIntent().getExtras();
        vm.cargarPropietario(bundle);
        binding.btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Propietario propietario= new Propietario();
                propietario.setApellido(binding.etApellido.getText().toString());
                propietario.setId(Integer.parseInt(binding.etCodigo.getText().toString()));
                propietario.setDni(Long.parseLong(binding.etDni.getText().toString()));
                propietario.setEmail(binding.etEmail.getText().toString());
                propietario.setNombre(binding.etNombre.getText().toString());
                propietario.setTelefono(binding.etTelefono.getText().toString());
                propietario.setContraseña(binding.etPass.getText().toString());
                vm.editar(propietario, getActivity());
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}