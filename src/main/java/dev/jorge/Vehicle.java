package dev.jorge;

import dev.jorge.enums.CarType;
import dev.jorge.enums.Color;
import dev.jorge.enums.FuelType;
public class Vehicle {

    private String brand;
    private int model;
    private double engine;
    private FuelType fuelType;
    private CarType carType;
    private int doorNumber;
    private int seatNumber;
    private Color color;
    private int maxSpeed;
    private int currentSpeed;

    // Alto Policia
    private boolean isAutomatic;
    private int fines;

    public Vehicle(String brand, int model, double engine, FuelType fuelType, CarType carType, int doorNumber,
            int seatNumber, Color color, int maxSpeed, int currentSpeed, boolean isAutomatic) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.fuelType = fuelType;
        this.carType = carType;
        this.doorNumber = doorNumber;
        this.seatNumber = seatNumber;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.isAutomatic = isAutomatic;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    // Alto policia
    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    // Methods

    public void accelerate(int speedIncrement) {
        if ((currentSpeed + speedIncrement) <= maxSpeed) {
            currentSpeed += speedIncrement;
        } else {
            System.out.println("Your speed exceeds the max speed for this vehicle");
            currentSpeed = maxSpeed; // establecemos la current speed como la max speed ya que se pasa
            fines++; // Alto policia
        }

    }

    public void decelerate(int speedDecrement) {
        if ((currentSpeed - speedDecrement) >= 0) {
            currentSpeed -= speedDecrement;
        } else {
            System.out.println("Your speed can't be below 0 km/h");
            currentSpeed = 0; // establecemos la current speed como 0 ya que si no seria negativa
        }

    }

    public void brake() {
        currentSpeed = 0;

    }

    public double estimatedTimeOfArrival(double distance) {
        if (currentSpeed > 0) {
            return distance / currentSpeed;
        } else {
            return 0;
        }

    }

    public boolean hasFines() { // Alto Policia
        if (fines > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int totalFines() {
        return fines;
    }

    public void display() {
        System.out.println("Vehicle Attributes:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Engine: " + engine + " L");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Car Type: " + carType);
        System.out.println("Number of Doors: " + doorNumber);
        System.out.println("Number of Seats: " + seatNumber);
        System.out.println("Color: " + color);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Current Speed: " + currentSpeed + " km/h");
        System.out.println("Automatic: " + isAutomatic);
    }

}