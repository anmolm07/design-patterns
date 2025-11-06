package design.practice.parking;

import design.patterns.factory.VehicleFactory;
import design.practice.parking.fee.BasicFeeStrategy;
import design.practice.parking.fee.ParkingFeeStrategy;
import design.practice.parking.fee.PremiumFeeStrategy;
import design.practice.parking.payment.CashPayment;
import design.practice.parking.payment.CreditCardPayment;
import design.practice.parking.payment.PaymentStrategy;
import design.practice.parking.slot.ParkingSlot;
import design.practice.parking.vehicles.BikeVehicle;
import design.practice.parking.vehicles.CarVehicle;
import design.practice.parking.vehicles.Vehicle;

public class ParkingLotMain {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingFeeStrategy basicHourlyRateStrategy = new BasicFeeStrategy();
        ParkingFeeStrategy premiumRateStrategy = new PremiumFeeStrategy();


        // Create vehicles using Factory Pattern with fee strategies
        Vehicle car1 = new CarVehicle("CAR123", basicHourlyRateStrategy);
        Vehicle car2 = new CarVehicle("CAR345", basicHourlyRateStrategy);

        Vehicle bike1 = new BikeVehicle("BIKE456", premiumRateStrategy);
        Vehicle bike2 = new BikeVehicle("BIKE123", premiumRateStrategy);

        // Park vehicles
        ParkingSlot carSpot = parkingLot.parkVehicle(car1);
        ParkingSlot bikeSpot = parkingLot.parkVehicle(bike1);
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy cashPayment = new CashPayment();
        parkingLot.vacateSpot(bikeSpot,bike1, creditCardPayment);
        parkingLot.vacateSpot(carSpot,car1, cashPayment);

    }
}