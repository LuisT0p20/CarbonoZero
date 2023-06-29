package com.example.clase1.Pojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clase1.Mensajes;
import com.example.clase1.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Mensajes> list;

    public CustomAdapter(Context context, List<Mensajes> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        TextView txtTitulo,txtDescripcion;
        Mensajes mensajes = list.get(i);
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.listview_recomendaciones,null);
        txtTitulo = view.findViewById(R.id.txtTituloRecomendacion);
        txtDescripcion = view.findViewById(R.id.txtDescripcionRecomendacion);

        txtTitulo.setText(mensajes.titulo);
        txtDescripcion.setText(mensajes.descripcion);
        return view;
    }
}
