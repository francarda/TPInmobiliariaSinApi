package com.example.tpinmobiliariasinapi.ui.contratos;

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
import com.example.tpinmobiliariasinapi.model.Pago;

import java.util.List;

public class PagoAdapter extends RecyclerView.Adapter<com.example.tpinmobiliariasinapi.ui.contratos.PagoAdapter.ViewHolder> {
    private List<Pago> pagos;
    private Context context;
    private LayoutInflater li;

    public PagoAdapter(List<Pago> pagos, Context context, LayoutInflater li) {
        this.pagos = pagos;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public com.example.tpinmobiliariasinapi.ui.contratos.PagoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_pagos, parent, false);


        return new com.example.tpinmobiliariasinapi.ui.contratos.PagoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.tpinmobiliariasinapi.ui.contratos.PagoAdapter.ViewHolder holder, int position) {
        holder.fechaPago.setText(pagos.get(position).getFechaDePago());
        holder.importe.setText("$" + pagos.get(position).getImporte());
        holder.codContrato.setText(pagos.get(position).getContrato().getIdContrato()+"");
        holder.numeroPago.setText(pagos.get(position).getNumero()+"");
        holder.codigo.setText(pagos.get(position).getIdPago()+"");
        holder.pago = pagos.get(position);


    }

    @Override
    public int getItemCount() {

        return pagos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView codigo;
        private TextView numeroPago;
        private TextView codContrato;
        private TextView importe;
        private TextView fechaPago;

        private Pago pago;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            codigo = itemView.findViewById(R.id.tvIdPagoP);
             numeroPago= itemView.findViewById(R.id.tvNumPago);
             codContrato= itemView.findViewById(R.id.tvCodigoContrat);
             importe= itemView.findViewById(R.id.tvImporteP);
             fechaPago=itemView.findViewById(R.id.tvFechaPago);



        }

    }
}
