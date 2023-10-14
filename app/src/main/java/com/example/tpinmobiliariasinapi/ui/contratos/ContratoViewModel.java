package com.example.tpinmobiliariasinapi.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.request.ApiClient;

import java.util.List;

public class ContratoViewModel extends ViewModel {
        private MutableLiveData<List<Inmueble>> mLista;

        private ApiClient api= ApiClient.getApi();

        public ContratoViewModel() {

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