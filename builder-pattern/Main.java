public class Main {
    public static void main(String[] args) {

        // With additonal features
        Computer computer1 = new Computer.ComputerBuilder("CPU1", "1TB").addGraphicsCard("Graphics Card 1")
                .addSSD("512TB").build();

        System.out.println(computer1);

        // Without additional features
        Computer computer2 = new Computer.ComputerBuilder("CPU2", "256GB").build();

        System.out.println(computer2);
    }
}