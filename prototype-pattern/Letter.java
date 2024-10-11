public class Letter implements Document {
    @Override
    public Document clone() {
        return new Letter();
    }

    @Override
    public void display() {
        System.out.println("Letter content");
    }
}
