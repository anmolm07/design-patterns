package design.patterns.strategy.payment;

import java.util.Scanner;

public class UPIPayment implements PaymentStrategy {

    public void pay(int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your UPI ID");
        String upiId = scanner.nextLine();
        System.out.println(" UPI payment of amount:" + amount + " is completed with UPI id: " + upiId);
    }
}
