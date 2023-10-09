package com.example.tpinmobiliariasinapi.ui.logout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dialogo {

    public static void mostrarDialogoBotones(Activity context){

        new AlertDialog.Builder(context)
                .setTitle("Cerrando")
                .setMessage("Esta seguro que desea cerrar la sesión?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((AppCompatActivity)context).finishAndRemoveTask();
                        context.finishAffinity();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"Contimnuamos",Toast.LENGTH_LONG).show();
                    }
                })
                .show();

    }


}
