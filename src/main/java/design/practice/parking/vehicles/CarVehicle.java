package design.practice.parking.vehicles;

import design.practice.parking.fee.ParkingFeeStrategy;

public class CarVehicle extends Vehicle {
    public CarVehicle(String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleNumber, VehicleType.Car, parkingFeeStrategy);
    }
}