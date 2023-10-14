package com.example.tpinmobiliariasinapi.ui.inquilinos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.model.Inmueble;

import java.util.List;

public class InquilinoAdapter extends RecyclerView.Adapter<com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdapter.ViewHolderB> {
    private List<Inmueble> inmuebles;
    private Context context;
    private LayoutInflater li;

    public InquilinoAdapter(List<Inmueble> inmuebles, Context context, LayoutInflater li) {
        this.inmuebles = inmuebles;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdapter.ViewHolderB onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_inquilino, parent, false);


        return new com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdapter.ViewHolderB(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.tpinmobiliariasinapi.ui.inquilinos.InquilinoAdapter.ViewHolderB holder, int position) {
        holder.direccion.setText("Titulo: " + inmuebles.get(position).getDireccion());
        holder.precio.setText("Director: " + inmuebles.get(position).getPrecio());

        holder.inmueble = inmuebles.get(position);


    }

    @Override
    public int getItemCount() {

        return inmuebles.size();
    }

    public class ViewHolderB extends RecyclerView.ViewHolder {
        private TextView direccion;
        private TextView precio;
        private Inmueble inmueble;

        public ViewHolderB(@NonNull View itemView) {
            super(itemView);

            direccion = itemView.findViewById(R.id.tvLPago);
            precio = itemView.findViewById(R.id.tvLNPago);


            itemView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("Inmueble", inmueble);
                    //bundle.putSerializable("nota", "algo");
                    // tengo que crear ese fragment
                    Navigation.findNavController(view).navigate(R.id.inquilinoDetalle, bundle);


                }
            });


        }
    }

}