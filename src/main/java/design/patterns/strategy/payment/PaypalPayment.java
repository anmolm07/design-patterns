package design.patterns.strategy.payment;

import java.util.Scanner;

public class PaypalPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your email");
        String email = scanner.nextLine();
        System.out.println(amount + " paid using PayPal account: " + email);
    }
}