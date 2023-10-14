package com.example.tpinmobiliariasinapi.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.request.ApiClient;

import java.util.List;

public class InquilinosViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> mLista;

    private ApiClient api= ApiClient.getApi();

    public InquilinosViewModel() {

    }
    public LiveData<List<Inmueble>> getMlista(){
        if(mLista==null){
            mLista= new MutableLiveData<>();
        }
        return mLista;
    }
    public void cargarLista(){

        mLista.setValue(api.obtenerPropiedadesAlquiladas());
    }



}