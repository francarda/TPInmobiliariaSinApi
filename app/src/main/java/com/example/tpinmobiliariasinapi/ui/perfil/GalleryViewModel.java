package com.example.tpinmobiliariasinapi.ui.perfil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.MainActivity;
import com.example.tpinmobiliariasinapi.model.Propietario;
import com.example.tpinmobiliariasinapi.request.ApiClient;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<Propietario> mPropietario= new MutableLiveData<>();
    private Propietario propietario;
    private Context context;
    private ApiClient api;

    public GalleryViewModel() {
    api= ApiClient.getApi();

    }

    public LiveData<Propietario> getMPropietario() {


        return mPropietario;
    }

    public void cargarPropietario(){

       /*
        if (bundle!=null){
            propietario= (Propietario) bundle.getSerializable("propietario");
            mPropietario.setValue(propietario);

            Log.d("salida", "propietario: " + propietario.getNombre());

        }*/
        Propietario actual= api.obtenerUsuarioActual();
       // Propietario actual= MainActivity.prop;
        mPropietario.setValue(actual);

    }

    public void editar(Propietario propietario, Context context) {

        api.actualizarPerfil(propietario);
        mPropietario.setValue(propietario);
        Toast.makeText(context, "Propietario actuaizado correctamente", Toast.LENGTH_SHORT).show();
    }
}