package com.example.android.car;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Car car;
    private TextView registerTextView;
    private TextView speedTextView;
    private TextView fuelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerTextView = findViewById(R.id.register_textView);
        speedTextView = findViewById(R.id.speed_textView);
        fuelTextView = findViewById(R.id.fuel_textView);

        car = new Car();

        registerTextView.setText(car.getRegister());
        updateCarInfo();
    }

    public void accelerate(View view) {
        car.accelerate();
        updateCarInfo();
    }

    public void decelerate(View view) {
        car.decelerate();
        updateCarInfo();
    }

    public void updateCarInfo() {
        speedTextView.setText(Integer.toString((int)car.getSpeed()));
        fuelTextView.setText(Integer.toString((int)car.getFuel()));
    }
}
