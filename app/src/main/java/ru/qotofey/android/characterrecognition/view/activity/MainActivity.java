package ru.qotofey.android.characterrecognition.view.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import ru.qotofey.android.characterrecognition.view.component.DrawView;

public class MainActivity extends BaseActivity {
    private boolean dialogOnScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new DrawView(this));

        // Определение размера экрана
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        // Альбомная ориентация только для сверхбольших планшетов
        if (screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        // Получение объекта SensorManager
        SensorManager sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        sensorManager.unregisterListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Получение объекта SensorManager
        SensorManager sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        // Регистрация для прослушивания событий акселерометра
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    // Обработчик для событий акселерометра
    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        // Проверка встряхивания по показаниям акселерометра
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (!dialogOnScreen) {
                // Получить значения x, y и z для SensorEvent
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                // Сохранить предыдущие данные ускорения
//                lastAcceleration = currentAcceleration;
            }
        }

        // Обязательный метод интерфейса SensorEventListener
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };
}

