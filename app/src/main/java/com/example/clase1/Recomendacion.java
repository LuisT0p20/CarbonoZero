package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.clase1.Pojo.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class Recomendacion extends AppCompatActivity {
    ListView ListViewMensaje;
    List<Mensajes> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendacion);
        ListViewMensaje = findViewById(R.id.ListViewMensajes);
        CustomAdapter adapter = new CustomAdapter(this, GetData());
        ListViewMensaje.setAdapter(adapter);
    }

    private List<Mensajes> GetData() {
        list = new ArrayList<>();
        list.add(new Mensajes(1,"Opta por alimentos de origen vegetal","Incorpora más frutas, verduras, legumbres, cereales integrales y frutos secos en tu dieta. Los alimentos de origen vegetal requieren menos recursos y generan menos emisiones de carbono que los productos de origen animal."));
        list.add(new Mensajes(2,"Consume alimentos locales y de temporada","Prefiere los productos cultivados cerca de tu ubicación y que estén en temporada. De esta manera, se reduce la necesidad de transportar los alimentos a largas distancias y se disminuyen las emisiones de gases de efecto invernadero."));
        list.add(new Mensajes(3,"Reduce el desperdicio de alimentos","Planifica tus comidas, compra solo lo necesario y aprovecha al máximo los ingredientes que tienes en casa. Trata de utilizar las sobras en nuevas preparaciones o congélalas para evitar que se desperdicien."));
        list.add(new Mensajes(4,"Evita los alimentos procesados y envasados"," Los alimentos procesados suelen requerir más energía en su producción y generan una mayor cantidad de residuos de envases. Opta por alimentos frescos y prepara tus comidas en casa."));
        list.add(new Mensajes(5,"Disminuye el consumo de carne y lácteos","Reducir el consumo de carne y lácteos puede tener un impacto significativo en la reducción de la huella de carbono personal. Intenta incorporar más opciones vegetarianas o veganas en tu dieta."));
        list.add(new Mensajes(6,"Elige pescado de forma responsable","Si consumes pescado, infórmate sobre prácticas de pesca sostenible y elige productos certificados como MSC (Marine Stewardship Council). Evita especies en peligro de extinción y pesca ilegal."));
        list.add(new Mensajes(7,"Haz compras conscientes","Investiga y apoya a empresas y productores que sigan prácticas sostenibles y respetuosas con el medio ambiente. Lee las etiquetas y busca certificaciones de calidad y sostenibilidad."));
        list.add(new Mensajes(8,"Reduce el consumo de agua","El proceso de producción de alimentos requiere grandes cantidades de agua. Ahorra agua al lavar los alimentos de manera eficiente y considera opciones de riego y agricultura más sostenibles."));
        list.add(new Mensajes(9,"Comparte tus conocimientos","Educa a tus amigos y familiares sobre la importancia de reducir la huella de carbono a través de la alimentación. Comparte recetas y consejos para promover un estilo de vida más sostenible."));
        list.add(new Mensajes(10,"Cultiva tus propios alimentos","Si es posible, considera cultivar tus propias frutas, verduras o hierbas. Esto no solo reduce la huella de carbono, sino que también te conecta con los alimentos y te brinda una experiencia gratificante."));
        return list;
    }
}