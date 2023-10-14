package com.example.tpinmobiliariasinapi.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.model.Inquilino;
import com.example.tpinmobiliariasinapi.request.ApiClient;

public class InquilinoDetalleViewModel extends ViewModel {
    private ApiClient api= ApiClient.getApi();
    private MutableLiveData<Inquilino> mInquilino;

    public LiveData<Inquilino> getMInquilino(){
        if (mInquilino==null){
            mInquilino= new MutableLiveData<>();
        }
        return mInquilino;
    }


    public void cargarInquilino(Bundle bundle) {
        Inmueble inmueble= (Inmueble) bundle.getSerializable("Inmueble");
        Inquilino inquilino= api.obtenerInquilino(inmueble);

        mInquilino.setValue(inquilino);
    }
}