package design.practice.parking.fee;

import design.practice.parking.vehicles.VehicleType;

public class PremiumFeeStrategy implements ParkingFeeStrategy {
    @Override
    public double calculateFee(VehicleType vehicleType, int duration) {
        return switch (vehicleType) {
            case Bike -> duration * 4.0;
            case Car -> duration * 8.0;
            default -> duration * 6.0;
        };
    }
}
