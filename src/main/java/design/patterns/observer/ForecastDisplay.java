package design.patterns.observer;

class ForecastDisplay implements Observer {
    private float lastTemperature;
    private float currentTemperature;

    @Override
    public void update(float temperature) {
        this.lastTemperature = this.currentTemperature;
        this.currentTemperature = temperature;
        display();
    }

    public void display() {
        if (currentTemperature > lastTemperature) {
            System.out.println("Forecast Display: Improving weather!");
        } else if (currentTemperature < lastTemperature) {
            System.out.println("Forecast Display: Worsening weather!");
        } else {
            System.out.println("Forecast Display: Same weather conditions.");
        }
    }
}