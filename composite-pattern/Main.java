public class Main {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 1000);
        Product mouse = new Product("Mouse", 50);

        Bundle accessories = new Bundle("Accessories Bundle");
        Product phoneCase = new Product("Phone Case", 20);
        accessories.addProduct(phoneCase);

        Bundle tech = new Bundle("Tech Bundle");
        Product headphones = new Product("Headphones", 200);
        Product keyboard = new Product("Keyboard", 150);

        tech.addProduct(headphones);
        tech.addProduct(keyboard);

        accessories.addProduct(tech);

        Bundle finalCart = new Bundle("Final Cart");
        finalCart.addProduct(laptop);
        finalCart.addProduct(mouse);
        finalCart.addProduct(accessories);

        finalCart.showDetails();
        System.out.println("Final cart price = " + finalCart.getPrice());

    }
}
