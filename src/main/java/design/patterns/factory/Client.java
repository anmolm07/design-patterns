package design.patterns.factory;

import design.patterns.factory.vehicle.Vehicle;

public class Client {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        // Get a Car object
        Vehicle car = factory.getVehicle(VehicleType.CAR);
        if (car != null) {
            car.drive();
        }

        // Get a Bike object
        Vehicle bike = factory.getVehicle(VehicleType.BIKE);
        if (bike != null) {
            bike.drive();
        }

        // Get a Truck object
        Vehicle truck = factory.getVehicle(VehicleType.TRUCK);
        if (truck != null) {
            truck.drive();
        }
    }
}