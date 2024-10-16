## Problem Statement

You are working on a **payment processing system** for an e-commerce website. The system currently uses a **single payment gateway** (let's call it `PayPal`) to process payments. Now, your business needs to integrate two additional payment gateways: `Stripe` and `Razorpay`, but their interfaces are different from the current system.

You need to use the **Adapter Design Pattern** to integrate the new payment gateways while keeping the existing `PayPal` implementation unchanged. The client code should interact with all payment gateways through a common interface.

### Problem Requirements

1. **PaymentProcessor Interface**: This is the common interface that all payment gateways should implement. It has a single method `processPayment(double amount)`.
2. **PayPal**: Already integrated into the system with a method `makePayment(double amount)` to process payments.
3. **Stripe**: Provides a method `stripePayment(double amount)` to process payments.
4. **Razorpay**: Uses a method `razorpayProcess(double amount)` to handle payments.

**Key Operations:**

- Create an adapter for each of the new payment gateways (`StripeAdapter` and `RazorpayAdapter`) that implements the `PaymentProcessor` interface and translates the calls from the client into calls to the respective payment gateway.
- Ensure that the client code only interacts with the `PaymentProcessor` interface.

**Classes to implement:**

1. **PaymentProcessor (Target Interface)**: Defines `processPayment(double amount)` as the common method for processing payments.
2. **PayPal**: A class with the method `makePayment(double amount)` that processes payments.
3. **StripeAdapter**: An adapter class that adapts the `Stripe` payment gateway's interface to the `PaymentProcessor` interface.
4. **RazorpayAdapter**: An adapter class that adapts the `Razorpay` payment gateway's interface to the `PaymentProcessor` interface.
5. **Client**: A class that processes payments through any payment gateway using the `PaymentProcessor` interface.
