import java.util.*;

public class Main {
    private static HashMap<String, Card> cards = new HashMap<>();
    private static HashSet<String> returnJourney = new HashSet<>();

    private static HashMap<String, Integer> centralPassengersCount = new HashMap<>();
    private static HashMap<String, Integer> airportPassengersCount = new HashMap<>();

    private static int centralAmount = 0;
    private static int airportAmount = 0;

    private static int centralDiscount = 0;
    private static int airportDiscount = 0;

    // BALANCE Command
    private static void balance(String cardNumber, int balance) {
        cards.put(cardNumber, new Card(cardNumber, balance));
    }

    // CHECK_IN Command
    private static void checkIn(String cardNumber, String type, String fromStation) {
        if (!cards.containsKey(cardNumber)) {
            System.out.println("CARD_NOT_FOUND");
            return;
        }

        int fare;
        switch (type) {
            case "ADULT":
                fare = 200;
                break;
            case "SENIOR_CITIZEN":
                fare = 100;
                break;
            case "KID":
                fare = 50;
                break;
            default:
                System.out.println("INVALID_PASSENGER_TYPE");
                return;
        }

        int finalFare = fare;
        int discount = 0;

        // Return journey discount
        if (returnJourney.contains(cardNumber)) {
            discount = fare / 2;
            finalFare = fare - discount;
        }

        // Check balance and auto-recharge if needed
        Card card = cards.get(cardNumber);
        if (card.balance < finalFare) {
            int rechargeAmount = finalFare - card.balance;
            int serviceFee = (int) Math.ceil(0.02 * rechargeAmount);
            card.balance += rechargeAmount + serviceFee;

            if (fromStation.equals("CENTRAL")) {
                centralAmount += serviceFee;
            } else {
                airportAmount += serviceFee;
            }
        }

        // Deduct fare and update station collections
        card.balance -= finalFare;
        cards.put(cardNumber, card);

        if (fromStation.equals("CENTRAL")) {
            centralAmount += finalFare;
            centralDiscount += discount;
            centralPassengersCount.put(type, centralPassengersCount.getOrDefault(type, 0) + 1);
        } else {
            airportAmount += finalFare;
            airportDiscount += discount;
            airportPassengersCount.put(type, airportPassengersCount.getOrDefault(type, 0) + 1);
        }

        // Mark as a return journey
        if (!returnJourney.contains(cardNumber)) {
            returnJourney.add(cardNumber);
        }
    }

    // PRINT_SUMMARY Command
    private static void printSummary() {
        System.out.println("TOTAL_COLLECTION CENTRAL " + centralAmount + " " + centralDiscount);
        System.out.println("PASSENGER_TYPE_SUMMARY");
        printPassengerSummary(centralPassengersCount);

        System.out.println("TOTAL_COLLECTION AIRPORT " + airportAmount + " " + airportDiscount);
        System.out.println("PASSENGER_TYPE_SUMMARY");
        printPassengerSummary(airportPassengersCount);
    }

    private static void printPassengerSummary(HashMap<String, Integer> passengersCount) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(passengersCount.entrySet());
        sortedList.sort((e1, e2) -> {
            if (e2.getValue().equals(e1.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue() - e1.getValue();
        });

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();
            if (command.equals("EXIT")) {
                break;
            }

            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "BALANCE":
                    balance(parts[1], Integer.parseInt(parts[2]));
                    break;
                case "CHECK_IN":
                    checkIn(parts[1], parts[2], parts[3]);
                    break;
                case "PRINT_SUMMARY":
                    printSummary();
                    break;
                default:
                    System.out.println("INVALID_COMMAND");
            }
        }
        sc.close();
    }
}
