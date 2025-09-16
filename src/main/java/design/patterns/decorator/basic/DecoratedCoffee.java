package design.patterns.decorator.basic;

public abstract class DecoratedCoffee implements Coffee {
    protected final Coffee delegate;

    public DecoratedCoffee(Coffee delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getDescription() {
        return this.delegate.getDescription();
    }

    @Override
    public double getCost() {
        return this.delegate.getCost();
    }
}
