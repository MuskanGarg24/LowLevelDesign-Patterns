public class Main {
    public static void main(String[] args) {

        // Simple pizza
        Pizza pizza = new Margherita();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.cost());

        // Pizza with extra cheese
        pizza = new Cheese(pizza);
        System.out.println(pizza.getDescription());
        System.out.println(pizza.cost());

        // Pizza with extra cheese, sauce and peppers
        pizza = new Peppers(new Sauce(pizza));
        System.out.println(pizza.getDescription());
        System.out.println(pizza.cost());

    }
}