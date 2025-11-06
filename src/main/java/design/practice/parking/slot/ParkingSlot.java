package design.practice.parking.slot;

import design.practice.parking.vehicles.Vehicle;
import design.practice.parking.vehicles.VehicleType;

public abstract class ParkingSlot {
    private int slotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract boolean canParkVehicle(VehicleType vehicleTpe);

    public void parkVehicle(Vehicle vehicle) {
        if(isOccupied) {
            throw new IllegalStateException("Parking already occupied");
        }
        if(!canParkVehicle(vehicle.getVehicleType())) {
            throw new IllegalStateException("Parking slot is not suitable for " + vehicle.getVehicleType());
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacate(){
        if(!isOccupied) {
            throw new IllegalStateException("Parking Spot is empty");
        }
        vehicle = null;
        isOccupied = false;
    }

}
