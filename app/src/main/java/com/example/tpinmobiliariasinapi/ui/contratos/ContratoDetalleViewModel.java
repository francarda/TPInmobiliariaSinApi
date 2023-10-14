package com.example.tpinmobiliariasinapi.ui.contratos;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Contrato;
import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.request.ApiClient;

public class ContratoDetalleViewModel extends ViewModel {
    private ApiClient api= ApiClient.getApi();
    private MutableLiveData<Contrato> mContrato;

    public MutableLiveData<Contrato> getMInquilino(){
        if (mContrato==null){
            mContrato= new MutableLiveData<>();
        }
        return mContrato;
    }


    public void cargarInquilino(Bundle bundle) {
        Inmueble inmueble= (Inmueble) bundle.getSerializable("Inmueble");
        Contrato contrato = api.obtenerContratoVigente(inmueble);

        mContrato.setValue(contrato);
    }

    public void cargarContrato(Bundle bundle) {
        Inmueble inmueble= (Inmueble) bundle.getSerializable("Inmueble");
        Contrato contrato= api.obtenerContratoVigente(inmueble);
        mContrato.setValue(contrato);

    }
}