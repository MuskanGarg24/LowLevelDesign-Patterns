## Problem Statement

You are building an online payment system that supports different payment methods such as Credit Card, PayPal, and Bitcoin. Each payment method has its own unique way of processing the payment.

- Credit Card requires card number and expiration date.
- PayPal requires the user's email and password.
- Bitcoin requires a wallet address.

Create a PaymentFactory that can generate the correct type of payment method based on user input, and implement classes for each payment method.

### Input Example

```bash
Payment payment = PaymentFactory.createPayment("PayPal");
payment.processPayment();
```