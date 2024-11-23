# Ride Sharing App

Once upon a time, there was a group of entrepreneurs who were busy building a new ride-sharing service. They were working tirelessly to make sure that their service was the best it could be for their riders (i.e passengers) and drivers. However, they knew that there was one important feature missing, the ability to match riders with drivers within a 5km range (inclusive).

One day, they realized that they needed to implement this feature as soon as possible, and they needed someone to take on the challenge of creating it. Can you help them to complete this?

### Euclidean Distance Formula

For ease of calculation, this service assumes a Cartesian coordinate system to represent locations, where the location of drivers and riders are represented as a Point(x, y). The Euclidean distance is utilized to calculate the distance between any two points, and 1 unit is equivalent to 1 km.

The Euclidean distance formula says:

d = √[ (x2–x1)^2 + (y2–y1)^2]

where,

(x1, y1) are the coordinates of one point.
(x2, y2) are the coordinates of the other point.
d is the distance between (x1, y1) and (x2, y2).

### Goal

Your task is to build a solution that will help to match riders with drivers based on their location and generate a bill for the ride.

### Assumptions

- It is guaranteed that no two drivers or riders will have the same id.
- Ride can only be started once the match is completed.
- Every start ride request will happen after the match request.
- Every start ride request will have a valid rider id.
- One rider can make multiple match requests.
- Bill for the ride will be calculated based on the distance between the rider's location and the destination.
- Bill can only be generated after the ride is completed.
- The driver will not be available to accept another rider's request after the ride has started.
- Time taken for a ride cannot be negative.
- All floating point numerical values must be rounded to two decimal places.

### Input Commands & Format

1. ADD_DRIVER: This command allows a driver to join the service. The command should take in the driver's id and current location (x_coordinate and y_coordinate) as arguments.

```bash
ADD_DRIVER <DRIVER_ID> <X_COORDINATE> <Y_COORDINATE>
```

2. ADD_RIDER: This command allows a rider to request a ride. The command should take in the rider's id, current location (x_coordinate and y_coordinate), as arguments.

```bash
ADD_RIDER <RIDER_ID> <X_COORDINATE> <Y_COORDINATE>
```

3. MATCH: Matches the rider with the nearest available drivers within 5 kms distance. Print nearest 5 drivers ids in ascending order of their distance from the rider in the following format. In the event of multiple drivers being equidistant, print them in lexicographical order. If no drivers are available then print ‘NO_DRIVERS_AVAILABLE’. Else, DRIVERS_MATCHED <DRIVER_ID1> <DRIVER_ID2> ... <DRIVER_ID5>

```bash
MATCH <RIDER_ID>
```

4. START_RIDE: Start the ride with the Nth Driver (1 >= N <= 5). If the match has fewer than N number of drivers, driver is not available, or <RIDE_ID> already exists, then print ‘INVALID_RIDE’ otherwise, print ‘RIDE_STARTED <RIDE_ID>’.

```bash
START_RIDE <RIDE_ID> <N> <RIDER_ID>
```

5. STOP_RIDE: If the <RIDE_ID> does not exist, or the ride is already stopped, then print ‘INVALID_RIDE’, otherwise, Print ‘RIDE_STOPPED <RIDE_ID>’

```bash
STOP_RIDE <RIDE_ID> <DESTINATION_X_COORDINATE> <DESTINATION_Y_COORDINATE> <TIME_TAKEN_IN_MIN>
```

6. BILL: Print the total bill of the ride in the format ‘BILL <RIDE_ID> <DRIVER_ID> <AMOUNT>’. To calculate the total bill use the following formula:

- A base fare of ₹50 is charged for every ride.
- An additional ₹6.5 is charged for every kilometer traveled.
- An additional ₹2 is charged for every minute spent in the ride.
- A service tax of 20% is added to the final amount.

```bash
BILL <RIDE_ID>
```

#### Note

- If the ride is not completed then print “RIDE_NOT_COMPLETED”
- If the <RIDE_ID> does not exist, then print ‘INVALID_RIDE’

### Sample Input/Output

#### Input

```bash
ADD_DRIVER D1 1 1
ADD_DRIVER D2 4 5
ADD_DRIVER D3 2 2
ADD_RIDER R1 0 0
MATCH R1
START_RIDE RIDE-001 2 R1
STOP_RIDE RIDE-001 4 5 32
BILL RIDE-001
```

#### Output

```bash
DRIVERS_MATCHED D1 D3
RIDE_STARTED RIDE-001
RIDE_STOPPED RIDE-001
BILL RIDE-001 D3 186.72
```
