package com.example.ejercicio2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensorLuz, sensorTemp, sensorHum, sensorPresion, sensorAceler;
    private SensorEventListener listenerLuz, listenerTemp, listenerHum, listenerPresion, listenerAceler;
    private boolean sensorsActive = false;

    private TextView tvSensorLuz, tvSensorTemp, tvSensorHum, tvSensorPresion, tvSensorAceler;
    private Button toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSensorLuz = findViewById(R.id.tvSensorLuz);
        tvSensorTemp = findViewById(R.id.tvSensorTemp);
        tvSensorHum = findViewById(R.id.tvSensorHum);
        tvSensorPresion = findViewById(R.id.tvSensorPresion);
        tvSensorAceler = findViewById(R.id.tvSensorAceler);
        toggleButton = findViewById(R.id.toggle_button);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorHum = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        sensorPresion = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sensorAceler = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        toggleButton.setOnClickListener(v -> {
            if (sensorsActive) {
                desactivarSensores();
            } else {
                activarSensores();
            }
        });

        configurarListeners();
    }

    private void configurarListeners() {
        listenerLuz = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tvSensorLuz.setText("Luz: " + event.values[0] + " lx");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };

        listenerTemp = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tvSensorTemp.setText("Temperatura: " + event.values[0] + " °C");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };

        listenerHum = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tvSensorHum.setText("Humedad: " + event.values[0] + " %");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };

        listenerPresion = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tvSensorPresion.setText("Presión: " + event.values[0] + " hPa");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };

        listenerAceler = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tvSensorAceler.setText("Acelerómetro: x=" + event.values[0] + ", y=" + event.values[1] + ", z=" + event.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };
    }

    private void activarSensores() {
        if (sensorLuz != null)
        {
            sensorManager.registerListener(listenerLuz, sensorLuz, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorTemp != null)
        {
            sensorManager.registerListener(listenerTemp, sensorTemp, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorHum != null)
        {
            sensorManager.registerListener(listenerHum, sensorHum, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorPresion != null)
        {
            sensorManager.registerListener(listenerPresion, sensorPresion, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensorAceler != null)
        {
            sensorManager.registerListener(listenerAceler, sensorAceler, SensorManager.SENSOR_DELAY_NORMAL);
        }

        toggleButton.setText("Desactivar Sensores");
        sensorsActive = true;
    }

    private void desactivarSensores() {
        sensorManager.unregisterListener(listenerLuz);
        sensorManager.unregisterListener(listenerTemp);
        sensorManager.unregisterListener(listenerHum);
        sensorManager.unregisterListener(listenerPresion);
        sensorManager.unregisterListener(listenerAceler);

        tvSensorLuz.setText("Luz: --");
        tvSensorTemp.setText("Temperatura: --");
        tvSensorHum.setText("Humedad: --");
        tvSensorPresion.setText("Presión: --");
        tvSensorAceler.setText("Acelerómetro: --");

        toggleButton.setText("Activar Sensores");
        sensorsActive = false;
    }
}
