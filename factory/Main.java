import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentFactory paymentFactory = new PaymentFactory();

        try {
            // Use credit card
            Payment creditCard = paymentFactory.createPayment("credit card");
            creditCard.processPayment(sc);

            // Use PayPal
            Payment paypal = paymentFactory.createPayment("paypal");
            paypal.processPayment(sc);

            // Use Bitcoin
            Payment bitcoin = paymentFactory.createPayment("bitcoin");
            bitcoin.processPayment(sc);

            // Try an invalid payment type
            Payment invalidPayment = paymentFactory.createPayment("invalid type");
            invalidPayment.processPayment(sc);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        finally {
            sc.close();
        }
    }
}
