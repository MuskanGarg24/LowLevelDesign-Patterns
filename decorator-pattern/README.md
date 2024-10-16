## Problem Statement

You are tasked with building an Online Pizza Ordering System where customers can order pizzas and add various toppings to them. The system should calculate the total price based on the base price of the pizza and the selected toppings. Use the Decorator Design Pattern to implement this.

### Problem Requirements

1. **Pizza (Component)**:
   - Define the base interface or abstract class for a pizza with methods:
     - `String getDescription()`: returns a description of the pizza.
     - `double cost()`: returns the total cost of the pizza.
2. **BasicPizza (Concrete Component)**:
   - A basic implementation of pizza (e.g., Margherita) with a default description and base cost.
3. **PizzaDecorator (Abstract Decorator)**:
   - An abstract decorator class that implements the pizza interface and contains a reference to a pizza object.
4. **Toppings (Concrete Decorators)**:
   - Create concrete decorators for various toppings such as:
     - Cheese
     - Peppers
     - Extra Sauce
   - Each topping will modify the description and cost of the pizza.

- Allow customers to dynamically add multiple toppings to the pizza.
- Each topping should add a specific cost to the total.
- The system should be able to print the final description of the pizza along with the total cost, including all the toppings added.
