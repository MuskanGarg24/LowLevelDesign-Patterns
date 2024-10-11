public class Report implements Document {
    @Override
    public Document clone() {
        return new Report();
    }

    @Override
    public void display() {
        System.out.println("Report content");
    }
}
