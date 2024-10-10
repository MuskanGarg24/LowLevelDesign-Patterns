## Problem Statement
You are designing a **Vehicle Manufacturing System** that produces two types of vehicles: **Cars** and **Bikes**. The system should support two types of fuels: **Petrol** and **Electric**. Each type of vehicle should have its own specific implementation based on the fuel type.

### Requirements
1. Create an abstract factory interface `VehicleFactory` that declares methods for creating `Car` and `Bike`.
2. Implement concrete factories `PetrolVehicleFactory` and `ElectricVehicleFactory` that create petrol and electric vehicles respectively.
3. Create abstract product interfaces `Car` and `Bike`, each having a method `drive()`.
4. Implement concrete product classes for `PetrolCar`, `PetrolBike`, `ElectricCar`, and `ElectricBike`, each with their own implementation of the `drive()` method.
5. The client code should be able to choose the factory based on the fuel type and drive the vehicles without knowing the underlying implementations.

### Input example
```bash
VehicleFactory factory = new PetrolVehicleFactory();

Car car = factory.createCar();
car.drive();

Bike bike = factory.createBike();
bike.drive();
```