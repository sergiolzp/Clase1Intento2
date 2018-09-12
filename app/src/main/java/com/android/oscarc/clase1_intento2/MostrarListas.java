package com.android.oscarc.clase1_intento2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MostrarListas extends Activity {
    ListView lista_predeterminada;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_lista);

        lista_predeterminada = findViewById(R.id.lista_predeterminada);
        String[] autos = new String[]{"ACURA","ABARTH","ALFA ROMEO","AUDI","BAIC","BENTLEY","BMW","BUICK","CADILLAC","CHEVROLET","CHRYSLER",
                "DODGE","FERRARI","FIAT","FORD","GMC","HONDA","HUMMER","HYUNDAI","INFINITI","JAGUAR","JEEP","KIA","LAND ROVER","LINCOLN","LOTUS","MASERATI",
                "MAYBACH","MAZDA","MERCEDES","MERCURY","MG","MINI","MITSUBISHI","NISSAN","PEUGEOT","PONTIAC","PORSCHE","RAM","RENAULT","ROVER","SAAB","SEAT",
                "SMART","SRT","SUBARU","SUZUKI","TESLA","TOYOTA","VOLKSWAGEN","VOLVO"};

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, autos);

        lista_predeterminada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MostrarListas.this, "Auto: " + (String) lista_predeterminada.getItemAtPosition(position) +
                        " Fila:" + String.valueOf(id),
                        Toast.LENGTH_LONG).show();
            }
        }

        );
        lista_predeterminada.setAdapter(adaptador);
    }
}
