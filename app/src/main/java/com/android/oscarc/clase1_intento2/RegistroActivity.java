
package com.android.oscarc.clase1_intento2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends Activity {
    EditText txt_nombreintent, txt_edadintent, txt_correointent;
    Button btn_enviarintent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_intent);
        txt_correointent = findViewById(R.id.txt_correointent);
        txt_edadintent = findViewById(R.id.txt_edadintent);
        txt_nombreintent = findViewById(R.id.txt_nombreintent);
        btn_enviarintent = findViewById(R.id.btn_enviarintent);
        btn_enviarintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNombre, sEdad, sCorreo;
                sNombre = txt_nombreintent.getText().toString();
                sEdad = txt_edadintent.getText().toString();
                sCorreo = txt_correointent.getText().toString();

                Intent intent = new Intent(RegistroActivity.this, DatosActivity.class);

                intent.putExtra("sNombre", sNombre);
                intent.putExtra("sEdad", sEdad);
                intent.putExtra("sCorreo", sCorreo);
                startActivity(intent);
            }
        });
    }
}