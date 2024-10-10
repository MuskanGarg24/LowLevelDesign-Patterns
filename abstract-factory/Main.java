public class Main {
    public static void main(String[] args) {

        VehicleFactory petrolFactory = new PetrolVehicleFactory();

        Car petrolCar = petrolFactory.createCar();
        petrolCar.drive();  

        Bike petrolBike = petrolFactory.createBike();
        petrolBike.ride();  

        VehicleFactory electricFactory = new ElectricVehicleFactory();

        Car electricCar = electricFactory.createCar();
        electricCar.drive(); 

        Bike electricBike = electricFactory.createBike();
        electricBike.ride(); 
    }
}
