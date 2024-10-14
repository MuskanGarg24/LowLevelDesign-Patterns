public class Computer {
    private String cpu;
    private String ram;
    private String graphicsCard;
    private String ssd;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.graphicsCard = builder.graphicsCard;
        this.ssd = builder.ssd;
    }

    @Override
    public String toString() {
        return "Computer [CPU = " + cpu + ",  RAM = " + ram + ", Graphics Card = " + graphicsCard + ", SSD = " + ssd
                + "]";
    }

    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String graphicsCard;
        private String ssd;

        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // Methods to set optional fields
        public ComputerBuilder addGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerBuilder addSSD(String ssd) {
            this.ssd = ssd;
            return this;
        }

        // Build method to create the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }

}
