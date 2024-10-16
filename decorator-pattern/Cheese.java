public class Cheese extends PizzaDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with cheese";
    }

    @Override
    public double cost() {
        return decoratedPizza.cost() + 10.0;
    }

}
