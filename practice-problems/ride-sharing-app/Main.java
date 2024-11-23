import java.util.*;

public class Main {

    private static final Map<String, Driver> drivers = new HashMap<>();
    private static final Map<String, Rider> riders = new HashMap<>();
    private static final Map<String, Ride> rides = new HashMap<>();

    // Calculate Euclidean Distance
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Add Driver
    private static void addDriver(String driverId, double x, double y) {
        drivers.put(driverId, new Driver(driverId, x, y));
    }

    // Add Rider
    private static void addRider(String riderId, double x, double y) {
        riders.put(riderId, new Rider(riderId, x, y));
    }

    // Match Drivers
    private static void matchRider(String riderId) {

        Rider rider = riders.get(riderId);

        if (rider == null) {
            System.out.println("NO_DRIVERS_AVAILABLE");
            return;
        }

        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.available && calculateDistance(driver.x, driver.y, rider.x, rider.y) <= 5) {
                availableDrivers.add(driver);
            }
        }

        if (availableDrivers.isEmpty()) {
            System.out.println("NO_DRIVERS_AVAILABLE");
            return;
        }

        availableDrivers.sort((d1, d2) -> {
            double dist1 = calculateDistance(d1.x, d1.y, rider.x, rider.y);
            double dist2 = calculateDistance(d2.x, d2.y, rider.x, rider.y);
            if (dist1 != dist2)
                return Double.compare(dist1, dist2);
            return d1.id.compareTo(d2.id);
        });

        System.out.print("DRIVERS_MATCHED");
        for (int i = 0; i < Math.min(5, availableDrivers.size()); i++) {
            System.out.print(" " + availableDrivers.get(i).id);
        }
        System.out.println();
    }

    // Start Ride
    private static void startRide(String rideId, int N, String riderId) {

        Rider rider = riders.get(riderId);

        if (rides.containsKey(rideId) || rider == null) {
            System.out.println("INVALID_RIDE");
            return;
        }

        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.available && calculateDistance(driver.x, driver.y, rider.x, rider.y) <= 5) {
                availableDrivers.add(driver);
            }
        }

        if (availableDrivers.size() < N) {
            System.out.println("INVALID_RIDE");
            return;
        }

        availableDrivers.sort((d1, d2) -> {
            double dist1 = calculateDistance(d1.x, d1.y, rider.x, rider.y);
            double dist2 = calculateDistance(d2.x, d2.y, rider.x, rider.y);
            if (dist1 != dist2)
                return Double.compare(dist1, dist2);
            return d1.id.compareTo(d2.id);
        });

        Driver selectedDriver = availableDrivers.get(N - 1);
        selectedDriver.available = false;

        rides.put(rideId, new Ride(rideId, selectedDriver.id, riderId, rider.x, rider.y));

        System.out.println("RIDE_STARTED " + rideId);

    }

    // Stop Ride
    private static void stopRide(String rideId, double endX, double endY, int timeTaken) {

        Ride ride = rides.get(rideId);

        if (ride == null || ride.endX != 0 || ride.endY != 0) {
            System.out.println("INVALID_RIDE");
            return;
        }

        ride.endX = endX;
        ride.endY = endY;
        ride.timeTaken = timeTaken;

        Driver driver = drivers.get(ride.driverId);
        if (driver != null) {
            driver.available = true;
        }
        System.out.println("RIDE_STOPPED " + rideId);
    }

    // Generate Bill
    private static void generateBill(String rideId) {
        Ride ride = rides.get(rideId);
        if (ride == null) {
            System.out.println("INVALID_RIDE");
            return;
        }

        if (ride.endX == 0 && ride.endY == 0) {
            System.out.println("RIDE_NOT_COMPLETED");
            return;
        }

        double distance = calculateDistance(ride.startX, ride.startY, ride.endX, ride.endY);
        double baseFare = 50;
        double distanceCost = distance * 6.5;
        double timeCost = ride.timeTaken * 2;
        double totalCost = (baseFare + distanceCost + timeCost) * 1.2;

        System.out.println("BILL " + rideId + " " + ride.driverId + " " + String.format("%.2f", totalCost));
    }

    // Client Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands (type 'EXIT' to stop):");

        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("EXIT")) {
                break;
            }

            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "ADD_DRIVER":
                    addDriver(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                    break;
                case "ADD_RIDER":
                    addRider(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                    break;
                case "MATCH":
                    matchRider(parts[1]);
                    break;
                case "START_RIDE":
                    startRide(parts[1], Integer.parseInt(parts[2]), parts[3]);
                    break;
                case "STOP_RIDE":
                    stopRide(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]),
                            Integer.parseInt(parts[4]));
                    break;
                case "BILL":
                    generateBill(parts[1]);
                    break;
                default:
                    System.out.println("INVALID_COMMAND");
            }
        }

        scanner.close();
    }
}
