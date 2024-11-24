# Metro Travel Charge Calculator

## Problem Context

A non-stop metro train operates between the **Central Station** and the **Airport Station**. Passengers use a **MetroCard** as an electronic wallet to pay for their travel. The system should handle:

- Passenger travel charges based on age.
- Automatic recharge of MetroCards when the balance is insufficient (including a 2% service fee).
- Discounts for return journeys.

The solution should provide a **collection summary** (total charges, discounts) and a **passenger summary** (number of passengers by type) for both stations.

## Features

1. **MetroCard Management**: Each passenger is assigned a unique MetroCard with a specific balance.
2. **Travel Charges**:
   - Adult: ₹200 per journey.
   - Senior Citizen: ₹100 per journey.
   - Kid: ₹50 per journey.
3. **Return Journey Discount**:
   - A 50% discount applies to the return trip on the same day.
4. **Auto-Recharge**:
   - Automatically recharges the MetroCard when the balance is insufficient.
   - Adds a 2% service fee on the recharge amount.
5. **Station-wise Summaries**:
   - Collection summary (total charges collected and total discount given).
   - Passenger summary (number of passengers per type, sorted as per requirements).

## Input Commands

#### **BALANCE**

`BALANCE <METROCARD_NUMBER> <BALANCE_IN_THE_METROCARD>`

- Adds balance to a MetroCard.
- Example: `BALANCE MC1 500`

#### **CHECK_IN**

`CHECK_IN <METROCARD_NUMBER> <PASSENGER_TYPE> <FROM_STATION>`

- Deducts travel charges from the MetroCard based on passenger type and station.
- Applies discounts for return journeys and recharges if necessary.
- Example: `CHECK_IN MC1 ADULT CENTRAL`

#### **PRINT_SUMMARY**

`PRINT_SUMMARY`

- Displays the total collection and passenger summaries for each station.

## Output Format

#### **Collection Summary**

`TOTAL_COLLECTION <STATION> <TOTAL_AMOUNT_COLLECTED> <TOTAL_DISCOUNT_GIVEN>`

#### **Passenger Summary**

`PASSENGER_TYPE_SUMMARY <PASSENGER_TYPE> <COUNT>`

## Assumptions

1. All passengers must have a MetroCard.
2. Travel costs are deducted before commencing the journey.
3. Service fees are applied to recharge amounts only.
4. Passenger counts are based on journeys (not unique individuals).

## Sample Input

```bash
BALANCE MC1 600
BALANCE MC2 500
BALANCE MC3 50
BALANCE MC4 50
BALANCE MC5 200
CHECK_IN MC1 ADULT CENTRAL
CHECK_IN MC2 SENIOR_CITIZEN CENTRAL
CHECK_IN MC1 ADULT AIRPORT
CHECK_IN MC3 KID AIRPORT
CHECK_IN MC4 ADULT AIRPORT
CHECK_IN MC5 KID AIRPORT
PRINT_SUMMARY
```

## Sample Output

```bash
TOTAL_COLLECTION CENTRAL 300 0
PASSENGER_TYPE_SUMMARY
ADULT 1
SENIOR_CITIZEN 1
TOTAL_COLLECTION AIRPORT 403 100
PASSENGER_TYPE_SUMMARY
ADULT 2
KID 2
```

### Explanation

#### Amount Collected at Central

- 200 (MC1): First journey from Central to Airport by MC1 (ADULT fare is ₹200).
- 100 (MC2): Journey from Central to Airport by MC2 (SENIOR_CITIZEN fare is ₹100).
- Total Amount Collected at Central = 200 + 100 = ₹300

#### Amount Collected at Airport

- 100 (MC1 Return): Return journey from Airport to Central by MC1 (ADULT return fare is 50% of ₹200 = ₹100).
- 50 (MC3): Journey from Airport to Central by MC3 (KID fare is ₹50).
- 200 (MC4): Journey from Airport to Central by MC4 (ADULT fare is ₹200).
- (2% Service Fee): Service fee collected for the recharge of ₹150 for MC4 (2% of ₹150 = ₹3).
- 50 (MC5): Journey from Airport to Central by MC5 (KID fare is ₹50).
- Total Amount Collected at Airport = 100 + 50 + 200 + 3 + 50 = ₹403

## Notes

- Use appropriate error handling for invalid commands, missing MetroCards, or insufficient balance.
- Ensure all outputs match the required format.
