import java.util.Scanner;

public class CreditCard implements Payment {
    @Override
    public void processPayment(Scanner sc) {
        System.out.println("Using credit card payment method..");

        System.out.print("Enter your card number: ");
        int cardNumber = sc.nextInt();

        System.out.print("Enter your card expiry date (MM/YYYY): ");
        String date = sc.next();

        System.out.println("Completed payment with card number: " + cardNumber + " and card expiry date: " + date);
    }
}
