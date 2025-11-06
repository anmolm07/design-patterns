package design.practice.parking.slot;

import design.practice.parking.vehicles.Vehicle;
import design.practice.parking.vehicles.VehicleType;

public class BikeParkingSlot extends ParkingSlot {
    public BikeParkingSlot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public boolean canParkVehicle(VehicleType vehicleType) {
        return VehicleType.Bike == vehicleType;
    }
}