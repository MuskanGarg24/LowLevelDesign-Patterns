import java.util.Scanner;

public class Paypal implements Payment {

    @Override
    public void processPayment(Scanner sc) {
        System.out.println("Using PayPal payment method..");

        System.out.print("Enter your username: ");
        String username = sc.next();

        System.out.print("Enter your password: ");
        String password = sc.next();

        if (password.isEmpty()) {
            System.out.println("Enter your password to complete the transaction");
        } else if (username.isEmpty()) {
            System.out.println("Enter your username to complete the transaction");
        } else {
            System.out.println("Hello " + username + ", your payment is successful");
        }
    }
}
