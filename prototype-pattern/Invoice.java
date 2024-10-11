public class Invoice implements Document {
    @Override
    public Document clone() {
        return new Invoice();
    }

    @Override
    public void display() {
        System.out.println("Invoice content");
    }
}
