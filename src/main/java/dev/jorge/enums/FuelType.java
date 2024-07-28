package dev.jorge.enums;

public enum FuelType {
    GASOLINE, BIOETHANOL, DIESEL, BIODIESEL, NATURAL_GAS;

    @Override
    public String toString() {
        return "FuelType: " + name();
    }
}