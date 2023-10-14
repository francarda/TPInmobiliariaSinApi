package com.example.tpinmobiliariasinapi.ui.inmubles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpinmobiliariasinapi.model.Inmueble;
import com.example.tpinmobiliariasinapi.request.ApiClient;

import java.util.List;

public class SlideshowViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> mLista;
    private final MutableLiveData<String> mText;
    private  ApiClient api= ApiClient.getApi();

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }
    public LiveData<List<Inmueble>> getMlista(){
        if(mLista==null){
            mLista= new MutableLiveData<>();
        }
        return mLista;
    }
    public void cargarLista(){
        mLista.setValue(api.obtnerPropiedades());
    }

    public LiveData<String> getText() {
        return mText;
    }
}