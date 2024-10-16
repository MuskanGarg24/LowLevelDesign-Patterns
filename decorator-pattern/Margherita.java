public class Margherita implements Pizza {

    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double cost() {
        return 50.0;
    }
}
