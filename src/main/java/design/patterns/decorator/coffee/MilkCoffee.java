package design.patterns.decorator.coffee;

import design.patterns.decorator.basic.DecoratedCoffee;
import design.patterns.decorator.basic.Coffee;

public class MilkCoffee extends DecoratedCoffee {

    public MilkCoffee(Coffee delegate) {
        super(delegate);
    }

    @Override
    public String getDescription() {
        return this.delegate.getDescription() + ", milk";
    }

    @Override
    public double getCost() {
        return this.delegate.getCost() + 1.0;
    }
}
