package com.example.android.car;

/**
 * Models a car that can accelerate and decelerate
 */

public class Car {
    private String register;
    private double fuel;
    private double speed;

    private final double maxSpeed;
    private final double maxFuel;

    /**
     * Constructor for all initial settings.
     * @param register Registration plate code
     * @param maxFuel Maximum fuel capacity
     * @param maxSpeed Maximum speed
     */
    public Car(String register, double maxFuel, double maxSpeed) {
        this.register = register;
        this.maxFuel = maxFuel;
        this.maxSpeed = maxSpeed;

        this.speed = 0.0;
        this.fuel = maxFuel;
    }

    public Car() {
        this("KPU-709", 55.0, 195.0);
    }

    public double getFuel() {
        return fuel;
    }

    public double getSpeed() {
        return speed;
    }

    public String getRegister() {
        return register;
    }

    /**
     * Algorithm that accelarates the car.
     * Fuel needed is calculated by formula: 1 + (int) (speed / 10.0)
     * If there is enough fuel, increases speed by formula:
     * Math.min((speed + 1.0) * (1.0 + 0.5 * (maxSpeed - speed) / maxSpeed), maxSpeed);
     */
    public void accelerate() {
        int fuelNeeded = 1 + (int) (speed / 10.0);
        if (fuel >= fuelNeeded) {
            fuel -= fuelNeeded;
            speed = Math.min((speed + 1.0) * (1.0 + 0.5 *
                    (maxSpeed - speed) / maxSpeed), maxSpeed);
            //System.out.println("speed: " + speed);
        }
    }

    public void decelerate() {
        speed = Math.max((speed - 1) * 0.5, 0.0);
    }
}


