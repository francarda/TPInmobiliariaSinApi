package com.example.tpinmobiliariasinapi.ui.inmubles;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Inmueble;

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

}