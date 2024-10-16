import java.util.ArrayList;
import java.util.List;

public class Bundle implements Cart {

    private String name;
    private double price;

    private List<Cart> bundles = new ArrayList<>();

    public Bundle(String name) {
        this.name = name;
        this.price = 0;
    }

    public void addProduct(Cart product) {
        bundles.add(product);
        price += product.getPrice();
    }

    public void removeProduct(Cart product) {
        bundles.remove(product);
        price -= product.getPrice();
    }

    @Override
    public void showDetails() {
        System.out.println("Bundle Name: " + name);
        for (Cart products : bundles) {
            products.showDetails();
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

}
