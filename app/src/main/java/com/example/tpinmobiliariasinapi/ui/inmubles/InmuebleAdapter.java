package com.example.tpinmobiliariasinapi.ui.inmubles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpinmobiliariasinapi.R;
import com.example.tpinmobiliariasinapi.model.Inmueble;

import java.util.List;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.ViewHolder> {
    private List<Inmueble> inmuebles;
    private Context context;
    private LayoutInflater li;

    public InmuebleAdapter(List<Inmueble> inmuebles, Context context, LayoutInflater li) {
        this.inmuebles = inmuebles;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_inmueble, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Inmueble inmueble= inmuebles.get(position);
        holder.direccion.setText("Dirección:" + inmuebles.get(position).getDireccion());
        holder.precio.setText("Precio: " + inmuebles.get(position).getPrecio());

        String nombreImagen = "casa_" + inmueble.getIdInmueble();

        // Obtiene el ID de la imagen a través de su nombre en el directorio de recursos
        int idImagen = holder.itemView.getResources().getIdentifier(nombreImagen, "drawable", holder.itemView.getContext().getPackageName());
        if (idImagen != 0) {
            holder.imagen.setImageResource(idImagen);
        } else {
            // Si no se encuentra la imagen, puedes cargar una imagen predeterminada o manejar el caso según tus necesidades
            holder.imagen.setImageResource(R.drawable.casa_501);
        }

        holder.inmueble = inmuebles.get(position);


    }

    @Override
    public int getItemCount() {

        return inmuebles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView direccion;
        private TextView precio;

        private ImageView imagen;
        private Inmueble inmueble;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            direccion = itemView.findViewById(R.id.tvDireccion);
            precio = itemView.findViewById(R.id.tvPrecio);
            imagen= itemView.findViewById(R.id.inmuebleImagen);


            itemView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    //estreno= new Estrenos("La orca","3h","Aldo venturi","1978");
                    bundle.putSerializable("Inmueble", inmueble);
                    //bundle.putSerializable("nota", "algo");
                    // tengo que crear ese fragment
                    Navigation.findNavController(view).navigate(R.id.inmuebleDetalle, bundle);


                }
            });


        }
    }

}
