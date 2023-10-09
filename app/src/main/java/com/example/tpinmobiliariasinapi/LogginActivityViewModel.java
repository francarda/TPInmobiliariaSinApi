package com.example.tpinmobiliariasinapi;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tpinmobiliariasinapi.model.Propietario;
import com.example.tpinmobiliariasinapi.request.ApiClient;

import java.io.Serializable;

public class LogginActivityViewModel extends AndroidViewModel {
    private Context context;

    public LogginActivityViewModel(@NonNull Application application) {
        super(application);
        context= application;
    }


    public void login(String mail, String pass){
        Propietario propietario;
       ApiClient api= ApiClient.getApi();
       propietario= api.login(mail,pass);
       if (propietario==null){
           Toast.makeText(context, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
       }else{
           Intent intent= new Intent(context, MainActivity.class);
           intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
           Bundle bundle= new Bundle();
           bundle.putSerializable("propietario", (Serializable) propietario);
           intent.putExtras(bundle);
           context.startActivity(intent);

       }


    }

}
