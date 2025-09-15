package design.patterns.strategy.cart;

import design.patterns.strategy.payment.PaymentStrategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int totalAmount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy set.");
            return;
        }
        paymentStrategy.pay(totalAmount);
    }
}
