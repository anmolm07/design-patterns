package design.patterns.decorator;

import design.patterns.decorator.basic.Coffee;
import design.patterns.decorator.coffee.BasicCoffee;
import design.patterns.decorator.coffee.Cuppuccino;
import design.patterns.decorator.coffee.MilkCoffee;

public class CoffeeShop {
        public static void main(String[] args) {
            Coffee myCoffee = new BasicCoffee();
            System.out.println("Order: " + myCoffee.getDescription() + " | Cost: $" + myCoffee.getCost());

            myCoffee = new MilkCoffee(myCoffee);
            System.out.println("Order: " + myCoffee.getDescription() + " | Cost: $" + myCoffee.getCost());

            myCoffee = new Cuppuccino(myCoffee);
            System.out.println("Order: " + myCoffee.getDescription() + " | Cost: $" + myCoffee.getCost());

            Coffee anotherCoffee = new Cuppuccino(new MilkCoffee(new BasicCoffee()));
            System.out.println("Order: " + anotherCoffee.getDescription() + " | Cost: $" + anotherCoffee.getCost());
        }
    }