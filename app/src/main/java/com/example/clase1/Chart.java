package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.clase1.Utilidades.Usuario;
import com.example.clase1.Utilidades.UsuarioAdapter;
import com.example.clase1.Utilidades.Util;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Chart extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    RecyclerView recyclerConsumo;
    ArrayList<Usuario> listaUsuarios;
    ProgressDialog progressDialog;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        listaUsuarios = new ArrayList<>();
        recyclerConsumo = findViewById(R.id.recycler_consumo);
        recyclerConsumo.setLayoutManager(new LinearLayoutManager(this));
        recyclerConsumo.setHasFixedSize(true);

        request = Volley.newRequestQueue(this);
        cargarWebService();

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(2, 5),
                new DataPoint(3, 3),
                new DataPoint(4, 2),
                new DataPoint(5, 6)
        });
        graph.addSeries(series);
    }

    private void cargarWebService() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando datos");
        progressDialog.show();
        String url = Util.RUTA + "consummer_consultation.php?id=1";
        url = url.replace(" ","%20");
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        progressDialog.hide();
        Usuario usuario = null;
        JSONArray json = response.optJSONArray("consumo");
        try {
            for (int i=0;i<json.length();i++){
                usuario = new Usuario();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);
                String nombre = jsonObject.optString("c_usuario");
                usuario.setNombre(nombre);
                Double consumo = jsonObject.optDouble("c_carbono");
                usuario.setConsumo(consumo);
                String fecha = jsonObject.optString("fecha");
                usuario.setFecha(fecha);
                listaUsuarios.add(usuario);
            }
            UsuarioAdapter adapter = new UsuarioAdapter(listaUsuarios);
            recyclerConsumo.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "No hay conexion con el servidor", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.hide();
        Toast.makeText(this, "Error " + error, Toast.LENGTH_SHORT).show();
    }
}