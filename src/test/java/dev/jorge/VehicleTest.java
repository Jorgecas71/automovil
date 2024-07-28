package dev.jorge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dev.jorge.enums.CarType;
import dev.jorge.enums.Color;
import dev.jorge.enums.FuelType;

public class VehicleTest {

    Vehicle vehicle = new Vehicle("Ferrari", 1997, 2.5, FuelType.DIESEL, CarType.CITY_CAR, 2, 4, Color.RED, 250, 0,
            false);

    @Test
    public void testAccelerateWithinLimit() {
        vehicle.accelerate(100);
        assertEquals(100, vehicle.getCurrentSpeed());
    }

    @Test
    public void testAccelerateBeyondLimit() {
        vehicle.setCurrentSpeed(240);
        vehicle.accelerate(20);
        assertEquals(250, vehicle.getCurrentSpeed());
        assertTrue(vehicle.hasFines());
        assertEquals(1, vehicle.totalFines());
    }

    @Test
    public void testDecelerateWithinLimit() {
        vehicle.setCurrentSpeed(100);
        vehicle.decelerate(50);
        assertEquals(50, vehicle.getCurrentSpeed());
    }

    @Test
    public void testDecelerateBeyondLimit() {
        vehicle.setCurrentSpeed(50);
        vehicle.decelerate(60);
        assertEquals(0, vehicle.getCurrentSpeed());
    }

    @Test
    public void testBrake() {
        vehicle.setCurrentSpeed(100);
        vehicle.brake();
        assertEquals(0, vehicle.getCurrentSpeed());
    }

    @Test
    public void testEstimatedTimeOfArrival() {
        vehicle.setCurrentSpeed(100);
        assertEquals(2.0, vehicle.estimatedTimeOfArrival(200), 0.01);
    }

    @Test
    public void testEstimatedTimeOfArrivalStop() {
        assertEquals(0, vehicle.estimatedTimeOfArrival(200), 0.01);
    }

    @Test
    public void testHasFines() {
        assertFalse(vehicle.hasFines());
        vehicle.accelerate(300);
        assertTrue(vehicle.hasFines());
    }

    @Test
    public void testTotalFines() {
        assertEquals(0, vehicle.totalFines());
        vehicle.accelerate(300);
        assertEquals(1, vehicle.totalFines());

        vehicle.accelerate(300);
        assertEquals(2, vehicle.totalFines());
    }
}
