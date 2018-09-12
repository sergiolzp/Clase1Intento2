package com.android.oscarc.clase1_intento2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class DatosActivity extends Activity {
    TextView lbl_nombre, lbl_edad, lbl_correo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        lbl_correo = findViewById(R.id.lbl_correo);
        lbl_edad = findViewById(R.id.lbl_edad);
        lbl_nombre = findViewById(R.id.lbl_nombre);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null ) {
            lbl_nombre.setText(bundle.getString("sNombre"));
            lbl_edad.setText(bundle.getString("sEdad"));
            lbl_correo.setText(bundle.getString("sCorreo"));
        }
    }
}
