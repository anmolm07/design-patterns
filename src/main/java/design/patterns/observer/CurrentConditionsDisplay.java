package design.patterns.observer;

class CurrentConditionsDisplay implements Observer {
    private float currentTemperature;

    @Override
    public void update(float temperature) {
        this.currentTemperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Current Conditions Display: Temperature = " + currentTemperature + "°C");
    }
}