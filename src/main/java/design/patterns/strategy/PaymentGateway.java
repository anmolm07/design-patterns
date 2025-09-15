package design.patterns.strategy;

import design.patterns.strategy.cart.ShoppingCart;
import design.patterns.strategy.payment.CreditCardPayment;
import design.patterns.strategy.payment.PaypalPayment;
import design.patterns.strategy.payment.UPIPayment;

import java.util.Scanner;

public class PaymentGateway {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount to pay");
        int totalAmount = scanner.nextInt();
        System.out.println("Please Choose the payment Strategy:  Press 1 for Credit Card , Press 2 for Paypal, Press 3 for UPI Payment.");
        int chosenOption = scanner.nextInt();
        payment(chosenOption,totalAmount);
    }

    private static void payment(int chosenOption, int totalAmount) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        switch (chosenOption) {
            case 1:
                cart.setPaymentStrategy(new CreditCardPayment());
                break;
            case 2:
                cart.setPaymentStrategy(new PaypalPayment());
                break;
            case 3:
                cart.setPaymentStrategy(new UPIPayment());
                break;
            default:
                System.out.println("Wrong Option");
                return;
        }
        cart.checkout(totalAmount);
    }
}
