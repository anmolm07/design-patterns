package design.practice.parking.vehicles;

import design.practice.parking.fee.ParkingFeeStrategy;

public class OtherVehicle extends Vehicle {
    public OtherVehicle(String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleNumber, VehicleType.Other, parkingFeeStrategy);
    }
}
