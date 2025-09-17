package design.patterns.factory.vehicle;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car");
    }
}