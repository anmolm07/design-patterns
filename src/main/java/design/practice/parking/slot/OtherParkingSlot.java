package design.practice.parking.slot;

import design.practice.parking.vehicles.Vehicle;
import design.practice.parking.vehicles.VehicleType;

public class OtherParkingSlot extends ParkingSlot {
    public OtherParkingSlot(int slotNumber) {
        super(slotNumber);
    }

    @Override
    public boolean canParkVehicle(VehicleType vehicleType) {
        return VehicleType.Other == vehicleType;
    }
}
