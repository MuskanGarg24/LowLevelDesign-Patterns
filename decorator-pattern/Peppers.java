public class Peppers extends PizzaDecorator {

    public Peppers(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with peppers";
    }

    @Override
    public double cost() {
        return decoratedPizza.cost() + 5.0;
    }

}
