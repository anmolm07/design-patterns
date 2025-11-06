package design.practice.parking.fee;

import design.practice.parking.vehicles.VehicleType;

public interface ParkingFeeStrategy {
    double calculateFee(VehicleType vehicleType, int duration);
}