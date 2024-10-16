## Problem Statement

You need to design a **Shopping Cart System** where customers can add individual items or item bundles (which contain multiple individual items) to their shopping cart. The system should allow the customer to:

1. Add individual products to the cart.
2. Add a bundle of products, where each bundle contains multiple products.
3. Calculate the total price of all the items in the cart.

### Problem Requirements

1. **Product**: Represents an individual product with a name and price.
2. **Bundle**: Represents a bundle that contains multiple products. A bundle may also include other bundles.
3. **Cart**: The shopping cart that can contain both products and bundles. The cart should be able to calculate the total price of the products and bundles it contains.

**Key Operations:**

- Add products to the cart.
- Add bundles (which may contain products and/or other bundles) to the cart.
- Calculate the total price of all items in the cart.

**Classes to implement:**

1. **Component (CartItem)**: An interface or abstract class that defines the common operations (`getPrice()` and `showDetails()`) for both individual products and bundles.
2. **Leaf (Product)**: A class that represents an individual product with a price.
3. **Composite (Bundle)**: A class that represents a bundle, which can contain multiple products and other bundles.

**Example:**

1. The user adds two individual products, "Laptop" ($1000) and "Mouse" ($50), to the cart.
2. The user adds a "Tech Bundle" which contains "Headphones" ($200) and "Keyboard" ($150).
3. The user adds another "Accessories Bundle" which contains "Phone Case" ($20) and the previously created "Tech Bundle".
4. The system calculates the total price of all items in the cart.

**Expected Methods:**

- `addItem(CartItem item)`
- `getPrice()`
- `showDetails()`

**Output:**

If the cart contains:

- **Laptop ($1000)**
- **Mouse ($50)**
- **Accessories Bundle:**
  - Phone Case ($20)
  - **Tech Bundle:**
    - Headphones ($200)
    - Keyboard ($150)

The system should calculate and display the total price as $1420 and show a list of items with their prices.
