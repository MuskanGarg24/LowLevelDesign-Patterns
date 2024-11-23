public class Ride {
    String rideId;
    String driverId;
    String riderId;
    double startX;
    double startY;
    double endX;
    double endY;
    int timeTaken;

    public Ride(String rideId, String driverId, String riderId, double startX, double startY) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.riderId = riderId;
        this.startX = startX;
        this.startY = startY;
    }
}
