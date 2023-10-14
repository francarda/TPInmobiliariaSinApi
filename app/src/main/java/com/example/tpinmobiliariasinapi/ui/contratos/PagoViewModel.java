package com.example.tpinmobiliariasinapi.ui.contratos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Contrato;
import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.model.Pago;
import com.example.tpinmobiliariasinapi.request.ApiClient;

import java.util.List;

public class PagoViewModel extends ViewModel {
    private MutableLiveData<List<Pago>> mLista;

    private ApiClient api= ApiClient.getApi();

    public PagoViewModel() {

    }
    public LiveData<List<Pago>> getMlista(){
        if(mLista==null){
            mLista= new MutableLiveData<>();
        }
        return mLista;
    }
    public void cargarLista(Bundle bundle){
        if(bundle!=null){
            Contrato contrato= (Contrato) bundle.getSerializable("Contrato");
            mLista.setValue(api.obtenerPagos(contrato));
        }
    }


}