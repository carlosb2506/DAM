package com.example.ejemplosensores;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener evento;
    private boolean mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mensaje = false;
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (sensor != null) {
            evento = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {

                    AlertDialog.Builder builder;

                    /*System.out.println("X = " + sensorEvent.values[0]);
                    System.out.println("Y = " + sensorEvent.values[1]);
                    System.out.println("Z = " + sensorEvent.values[2]);*/

                    //Si el telefono se ha girado: sensorEvent.values[0] != 0
                    if ((sensorEvent.values[0] > 5 || sensorEvent.values[0] < -5) && !mensaje)
                    {
                        mensaje = true;
                        builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Gire su teléfono a posicion vertical");
                        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                mensaje = false;
                            }
                        });

                        builder.create().show();
                    }

                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
            sensorManager.registerListener(evento, sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            //el dispositivo no tiene el sensor
        }
    }
}