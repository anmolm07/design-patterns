package design.practice.parking.vehicles;

import design.practice.parking.fee.ParkingFeeStrategy;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleNumber, VehicleType.Bike, parkingFeeStrategy);
    }
}