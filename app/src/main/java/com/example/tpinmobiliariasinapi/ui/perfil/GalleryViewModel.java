package com.example.tpinmobiliariasinapi.ui.perfil;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Propietario;
import com.example.tpinmobiliariasinapi.request.ApiClient;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<Propietario> mPropietario;
    private Propietario propietario;
    private Context context;
    public GalleryViewModel() {


    }

    public LiveData<Propietario> getMPropietario() {
        if(mPropietario== null){
            mPropietario= new MutableLiveData<>();

        }

        return mPropietario;
    }

    public void cargarPropietario(Bundle bundle){
        if (bundle==null){
            propietario= (Propietario) bundle.getSerializable("propietario");
            mPropietario.setValue(propietario);

        }

    }

    public void editar(Propietario propietario, Context context) {
        ApiClient api= ApiClient.getApi();
        api.actualizarPerfil(propietario);
        Toast.makeText(context, "Propietario actuaizado correctamente", Toast.LENGTH_SHORT).show();
    }
}