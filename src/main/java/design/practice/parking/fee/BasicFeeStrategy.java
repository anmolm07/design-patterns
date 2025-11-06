package design.practice.parking.fee;

import design.practice.parking.vehicles.VehicleType;

public class BasicFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double calculateFee(VehicleType vehicleType, int duration) {
        return switch (vehicleType) {
            case Bike -> duration * 5.0;
            case Car -> duration * 10.0;
            default -> duration * 8.0;
        };
    }
}
