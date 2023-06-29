package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.clase1.Utilidades.Usuario;
import com.example.clase1.Utilidades.UsuarioAdapter;
import com.example.clase1.Utilidades.Util;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Chart extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {
    RecyclerView recyclerConsumo;
    ArrayList<Usuario> listaUsuarios;
    ProgressDialog progressDialog;
    RequestQueue request;
    JsonArrayRequest jsonArrayRequest;

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
    }

    private void cargarWebService() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando datos");
        progressDialog.show();
        SharedPreferences sharedPreferences = getSharedPreferences("usuario_id", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        String url = Util.RUTA + "consummer_consultation.php?c_usuario=" + id;
        url = url.replace(" ", "%20");
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        progressDialog.hide();
        try {
            int numValuesToShow = 5;

            for (int i = response.length() - numValuesToShow; i < response.length(); i++) {
                JSONObject jsonObject = response.getJSONObject(i);
                String nombre = jsonObject.optString("u_nombre");
                double consumo = jsonObject.optDouble("c_carbono");
                String fecha = jsonObject.optString("fecha");
                Usuario usuario = new Usuario(nombre, consumo, fecha);
                listaUsuarios.add(usuario);
            }

            // Configurar los datos para el gráfico
            GraphView graph = findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoints(numValuesToShow));
            graph.addSeries(series);

            // Configurar el eje X del gráfico
            graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                @Override
                public String formatLabel(double value, boolean isValueX) {
                    if (isValueX) {
                        // Formatear el eje X con los valores del 1 al 5
                        return String.valueOf((int) value);
                    } else {
                        // No cambiar el formato del eje Y
                        return super.formatLabel(value, isValueX);
                    }
                }
            });

            // Actualizar el RecyclerView con los datos de consumo y fecha
            UsuarioAdapter adapter = new UsuarioAdapter(listaUsuarios);
            recyclerConsumo.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al procesar la respuesta JSON: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("JSON Error", e.getMessage());
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.hide();
        Toast.makeText(this, "Error al obtener los datos: " + error.toString(), Toast.LENGTH_SHORT).show();
        Log.e("Volley Error", error.toString());
    }

    private DataPoint[] getDataPoints(int numValues) {
        DataPoint[] dataPoints = new DataPoint[numValues];
        for (int i = 0; i < numValues; i++) {
            Usuario usuario = listaUsuarios.get(i);
            dataPoints[i] = new DataPoint(i + 1, usuario.getConsumo());
        }
        return dataPoints;
    }
}