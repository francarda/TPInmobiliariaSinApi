package com.example.tpinmobiliariasinapi;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpinmobiliariasinapi.model.Propietario;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Integer>foto;
    private MutableLiveData<Propietario> mPropietario;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context= application;
        
    }


    public void obtenerSerializalble(Bundle extras) {
        Propietario propietario= (Propietario) extras.getSerializable("propietario");
        mPropietario.setValue(propietario);
        if (propietario.getNombre().equals("Juan")){
            foto.setValue(R.drawable.juan);
        }else{
            foto.setValue(R.drawable.sonia);
        }



    }
    public LiveData<Integer> getFoto(){
        if(foto==null){
            foto= new MutableLiveData<>();
        }
        return foto;
    }
    public LiveData<Propietario> getMPropietario(){
        if(mPropietario==null){
            mPropietario= new MutableLiveData<>();
        }
        return mPropietario;
    }
    public void modificarPropietario(Propietario prop){
        mPropietario.setValue(prop);

    }
}
