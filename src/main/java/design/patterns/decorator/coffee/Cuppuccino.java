package design.patterns.decorator.coffee;

import design.patterns.decorator.basic.DecoratedCoffee;
import design.patterns.decorator.basic.Coffee;

public class Cuppuccino extends DecoratedCoffee {
    public Cuppuccino(Coffee delegate) {
        super(delegate);
    }

    @Override
    public double getCost() {
        return this.delegate.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return this.delegate.getDescription() + ", milk, layering of espresso, milk foam on top.";
    }
}
