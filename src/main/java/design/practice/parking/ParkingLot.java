package design.practice.parking;
import design.practice.parking.payment.PaymentStrategy;
import design.practice.parking.slot.BikeParkingSlot;
import design.practice.parking.slot.CarParkingSlot;
import design.practice.parking.slot.ParkingSlot;
import design.practice.parking.vehicles.Vehicle;
import design.practice.parking.vehicles.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSlot> parkingSlots;

    private ParkingLot(){
        parkingSlots = new ArrayList<ParkingSlot>();
        parkingSlots.add(new CarParkingSlot(1));
        parkingSlots.add(new CarParkingSlot(2));
        parkingSlots.add(new BikeParkingSlot(3));
        parkingSlots.add(new BikeParkingSlot(4));
    }

    private void initialize() {

    }

    private static class SingletonHolder {
        private static final ParkingLot INSTANCE = new ParkingLot();
    }

    public static synchronized ParkingLot getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public List<ParkingSlot> getParkingSpots() {
        return parkingSlots;
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType) {
        for (ParkingSlot slot : parkingSlots) {
            if (!slot.isOccupied() && slot.canParkVehicle(vehicleType)) {
                return slot;
            }
        }
        return null;
    }

    public ParkingSlot parkVehicle(Vehicle vehicle) {
        ParkingSlot slot = findAvailableSlot(vehicle.getVehicleType());
        if (slot != null) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime twoHoursEarlier = now.minusHours(2);
            vehicle.setInTime(twoHoursEarlier);
            slot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in spot: " + slot.getSlotNumber());
            return slot;
        }
        System.out.println("No parking spots available for " + vehicle.getVehicleType() + "!");
        return null;
    }

    public void vacateSpot(ParkingSlot slot, Vehicle vehicle, PaymentStrategy paymentStrategy) {
        if (slot != null && slot.isOccupied()
                && slot.getVehicle().equals(vehicle)) {
            double fees = vehicle.calculateFee();
            paymentStrategy.processPayment(fees);
            slot.vacate();
            System.out.println(vehicle.getVehicleType() + " vacated the spot: " + slot.getSlotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant "
                    + "or the vehicle does not match.");
        }
    }

}