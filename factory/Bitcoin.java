import java.util.Scanner;

public class Bitcoin implements Payment {

    @Override
    public void processPayment(Scanner sc) {
        System.out.println("Using Bitcoin payment method..");

        System.out.print("Enter your wallet address: ");
        String walletAddress = sc.next();

        if (walletAddress.isEmpty()) {
            System.out.println("Enter your wallet address to start the transaction");
        } else {
            System.out.println("Your transaction is successful using wallet address: " + walletAddress);
        }
    }
}
