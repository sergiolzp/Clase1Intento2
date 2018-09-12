package com.android.oscarc.clase1_intento2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class BroadcastBattery extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        int porcentaje = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

        Toast.makeText(context, "Batería al " + String.valueOf(porcentaje) + "%", Toast.LENGTH_LONG).show();

        if (intent.getAction().equals(intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "Dispositivo conectado", Toast.LENGTH_SHORT).show();
        }
        if (intent.getAction().equals(intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "Dispositivo desconectado", Toast.LENGTH_SHORT).show();
        }
    }
}
