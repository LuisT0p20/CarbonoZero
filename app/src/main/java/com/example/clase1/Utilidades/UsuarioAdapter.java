package com.example.clase1.Utilidades;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase1.R;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuariosHolder>{
    List<Usuario> listaUsuarios;
    public UsuarioAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    @NonNull
    @Override
    public UsuariosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuarios_list, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        vista.setLayoutParams(layoutParams);
        return new UsuariosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuariosHolder holder, int position) {
        holder.txtNombre.setText( String.valueOf(listaUsuarios.get(position).getNombre()) );
        holder.txtConsumo.setText( String.valueOf(listaUsuarios.get(position).getConsumo()) );
        holder.txtFecha.setText( String.valueOf(listaUsuarios.get(position).getFecha()) );
    }

    @Override
    public int getItemCount() {

        return listaUsuarios.size();
    }

    public class UsuariosHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtConsumo,txtFecha;
        public UsuariosHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.uli_Nombre);
            txtConsumo = itemView.findViewById(R.id.uli_Consumo);
            txtFecha = itemView.findViewById(R.id.uli_Fecha);
        }
    }
}
