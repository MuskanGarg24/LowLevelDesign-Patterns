public class PaymentFactory {

    public Payment createPayment(String type) {
        if (type.equalsIgnoreCase("Credit Card")) {
            return new CreditCard();
        } else if (type.equalsIgnoreCase("Paypal")) {
            return new Paypal();
        } else if (type.equalsIgnoreCase("Bitcoin")) {
            return new Bitcoin();
        } else {
            throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
