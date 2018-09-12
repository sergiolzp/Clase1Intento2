package com.android.oscarc.clase1_intento2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    EditText txt_nombre;
    TextView lbl_resultado;
    Button btn_mostrar, btn_alert;
    Button btn_implicito, btn_explicito;
    Button btn_listView1, btn_listView2;
    BroadcastBattery broadcastBattery = new BroadcastBattery();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setInitializeComponent();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastBattery, intentFilter);

        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Este es una manmera de usar el listener.
                la otra manera es con el implements y el método OnClick de más abajo */
            }
        });
        btn_alert.setOnClickListener(this);

        btn_mostrar.setOnClickListener(this);
        txt_nombre.setOnClickListener(this);
        btn_explicito.setOnClickListener(this);
        btn_implicito.setOnClickListener(this);
        btn_listView1.setOnClickListener(this);
        btn_listView2.setOnClickListener(this);
    }

    private void setInitializeComponent() {
        txt_nombre = findViewById(R.id.txt_nombre);
        lbl_resultado = findViewById(R.id.lbl_resultado);
        btn_mostrar = findViewById(R.id.btn_mostrar);
        btn_alert = findViewById(R.id.btn_alert);
        btn_implicito = findViewById(R.id.btn_implicito);
        btn_explicito = findViewById(R.id.btn_explicito);
        btn_listView1 = findViewById(R.id.btn_listView1);
        btn_listView2 = findViewById(R.id.btn_listView2);
    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_toast,
                (ViewGroup) findViewById(R.id.contenedor));
        String dato;
        TextView mensaje_custom = layout.findViewById(R.id.lbl_resultado);


        switch (v.getId()){
            case R.id.btn_mostrar:
                dato = String.valueOf(txt_nombre.getText());
                Toast mensaje = Toast.makeText(this, dato, Toast.LENGTH_LONG);
                mensaje.setGravity(Gravity.CENTER, 10, -10);
                mensaje_custom.setText(dato);
                //mensaje_custom.setText(txt_nombre.getText().toString());
                mensaje.setView(layout);

                mensaje.show();
                break;
            case R.id.txt_nombre: // Toast
                Toast mensaje2 = Toast.makeText(this, "HOLA", Toast.LENGTH_SHORT);
                mensaje2.setGravity(Gravity.CENTER, 50,50);
                mensaje2.show();
                break;
            case R.id.btn_alert: // Alert
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Guardar dato")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this, "Se aceptó", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        )
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this, "Se canceló", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        );
                alert.create();
                alert.show();

                break;

            case R.id.btn_implicito: // Intent
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://www.iteso.mx"));
                startActivity(intent2);
                break;
            case R.id.btn_explicito: // Intent
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_listView1:
                Intent intent3 = new Intent(MainActivity.this, MostrarListas.class);
                startActivity(intent3);

                break;
            case R.id.btn_listView2:
                Intent intent4 = new Intent(MainActivity.this, ListViewPersonalizado.class);
                Toast.makeText(MainActivity.this, "List View 2", Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                break;


        }
    }
}
