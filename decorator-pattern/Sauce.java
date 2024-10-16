public class Sauce extends PizzaDecorator {

    public Sauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with sauce";
    }

    @Override
    public double cost() {
        return decoratedPizza.cost() + 7.0;
    }
}
