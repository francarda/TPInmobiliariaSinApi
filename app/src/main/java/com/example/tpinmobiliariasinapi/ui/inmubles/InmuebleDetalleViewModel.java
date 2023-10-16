package com.example.tpinmobiliariasinapi.ui.inmubles;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.request.ApiClient;

public class InmuebleDetalleViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inmueble> mInmueble;

    public LiveData<Inmueble> getMInmueble(){
        if (mInmueble==null){
            mInmueble= new MutableLiveData<>();
        }
        return mInmueble;
    }
    public void cargarInmueble(Bundle bundle){
        Inmueble inmueble= (Inmueble) bundle.getSerializable("Inmueble");
        mInmueble.setValue(inmueble);
    }

    public void editarDisponible(boolean checked, Context context) {
        Inmueble inmueble= mInmueble.getValue();
        inmueble.setEstado(checked);
        mInmueble.setValue(inmueble);
        ApiClient api= ApiClient.getApi();
        api.actualizarInmueble(inmueble);
        Toast.makeText(context, "Inmueble Actualizado", Toast.LENGTH_SHORT).show();
    }
}