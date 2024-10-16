public class Main {
    public static void main(String[] args) {
        // PayPal payment
        Paypal paypal = new Paypal();
        PaymentProcessor paypalProcessor = new PaymentProcessor() {
            @Override
            public void processPayment(double amount) {
                paypal.makePayment(amount);
            }
        };
        paypalProcessor.processPayment(100);

        // Stripe payment through StripeAdapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(150);

        // Razorpay payment through RazorpayAdapter
        Razorpay razorpay = new Razorpay();
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(razorpay);
        razorpayProcessor.processPayment(200);
    }
}
