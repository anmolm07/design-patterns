package design.patterns.decorator.coffee;

import design.patterns.decorator.basic.Coffee;

public class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
