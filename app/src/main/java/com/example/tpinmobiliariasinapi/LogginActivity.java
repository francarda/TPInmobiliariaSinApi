package com.example.tpinmobiliariasinapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.Manifest;

import com.example.tpinmobiliariasinapi.databinding.ActivityLogginBinding;

public class LogginActivity extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL_PERMISSION = 1;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private SensorEventListener sensorListener;
    private ActivityLogginBinding binding;
    private LogginActivityViewModel vm;
    private static final float SHAKE_THRESHOLD = 800f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LogginActivityViewModel.class);
        binding = ActivityLogginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String pass=binding.etContraseA.getText().toString();
            String usuario= binding.etUsuario.getText().toString();
            vm.login(usuario, pass);
            }
        });
       sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);




        sensorListener = new SensorEventListener() {
            private long lastUpdate = 0;
            private float lastX, lastY, lastZ;

            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    long currentTime = System.currentTimeMillis();
                    if ((currentTime - lastUpdate) > 100) {
                        long timeDiff = currentTime - lastUpdate;
                        lastUpdate = currentTime;

                        float x = event.values[0];
                        float y = event.values[1];
                        float z = event.values[2];

                        float speed = Math.abs(x + y + z - lastX - lastY - lastZ) / timeDiff * 10000;

                        if (speed > SHAKE_THRESHOLD) {
                           llamarNumero();
                        }

                        lastX = x;
                        lastY = y;
                        lastZ = z;
                    }
                }
            }



            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // No es necesario implementar esto, pero es parte de la interfaz SensorEventListener.
            }
        };
    }
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorListener);
    }
    public void cargarPermisos(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL_PERMISSION);
            }
        }

    }
    public void llamarNumero() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "1234"));
        startActivity(intent);
    }
}