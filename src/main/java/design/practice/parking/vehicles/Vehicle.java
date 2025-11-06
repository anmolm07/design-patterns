package design.practice.parking.vehicles;

import design.practice.parking.fee.ParkingFeeStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private ParkingFeeStrategy parkingFeeStrategy;
    private LocalDateTime inTime;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, ParkingFeeStrategy parkingFeeStrategy) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public ParkingFeeStrategy getParkingFeeStrategy() {
        return parkingFeeStrategy;
    }

    public void updateParkingFeeStrategy(ParkingFeeStrategy parkingFeeStrategy) {
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public double calculateFee() {
        if (inTime == null) {
            throw new IllegalArgumentException("InTime is not present to calculate fee.");
        }
        int duration = getNumberOfHours();
        return parkingFeeStrategy.calculateFee(vehicleType, duration);
    }

    public int getNumberOfHours() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(inTime, now);
        long seconds = duration.getSeconds();
        double hours = seconds / 3600.0;
        inTime = null;
        return (int) Math.ceil(hours);
    }
}
