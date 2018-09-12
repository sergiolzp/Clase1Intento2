package com.android.oscarc.clase1_intento2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewPersonalizado extends Activity {
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lv_personalizable);
        listView = findViewById(R.id.list_pers);
        String[] marca = new String[]{"BMW", "VW", "KIA"};
        String[] modelo = new String[]{"Serch", "Gol", "Sportage"};
        String[] anio = new String[]{"2019", "1998", "2009"};

        int[] img_marca = new int[] {R.drawable.images, R.drawable.m2914726_249px, R.drawable.toyota};
        ItemAuto itemAuto;
        ArrayList<ItemAuto> arrayList = new ArrayList<>();
        AdapterAutos adapterAutos;

        for (int index = 0; index <= marca.length-1; index++){
           arrayList.add(new ItemAuto(marca[index], modelo[index], anio[index], img_marca[index]));
        }

        adapterAutos = new AdapterAutos(this, 0, arrayList);
        listView.setAdapter(adapterAutos);
    }
}
