package design.patterns.strategy.payment;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {


    public void pay(int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Credit Card Number");
        String cardNumber = scanner.nextLine();
        System.out.println("Please enter your Credit Card Name");
        String name = scanner.nextLine();
        System.out.println(amount + " paid with credit card: " + cardNumber + " on the name of " + name);
    }
}
