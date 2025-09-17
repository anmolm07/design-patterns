package design.patterns.factory;

import design.patterns.factory.vehicle.Bike;
import design.patterns.factory.vehicle.Car;
import design.patterns.factory.vehicle.Truck;
import design.patterns.factory.vehicle.Vehicle;

public class VehicleFactory {
    public Vehicle getVehicle(VehicleType vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equals(VehicleType.CAR)) {
            return new Car();
        } else if (vehicleType.equals(VehicleType.BIKE)) {
            return new Bike();
        } else if (vehicleType.equals(VehicleType.TRUCK)) {
            return new Truck();
        }
        return null;
    }
}