package design.practice.parking.slot;


import design.practice.parking.vehicles.Vehicle;
import design.practice.parking.vehicles.VehicleType;

public class CarParkingSlot extends ParkingSlot {
    public CarParkingSlot(int slotNumber) {
        super(slotNumber);
    }

    @Override
    public boolean canParkVehicle(VehicleType vehicleType) {
        return VehicleType.Car == vehicleType;
    }
}
