
import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateFare(double distance);
}

class Bike extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Trip {
    Rider rider;
    Driver driver;
    Vehicle vehicle;
    double distance;

    Trip(Rider rider, Driver driver,
         Vehicle vehicle, double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException(
                "Invalid distance"
            );
        }

        this.rider = rider;
        this.driver = driver;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    double getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Vehicle vehicle;

                switch (type) {
                    case "Bike":
                        vehicle = new Bike();
                        break;

                    case "Auto":
                        vehicle = new Auto();
                        break;

                    case "Cab":
                        vehicle = new Cab();
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Invalid ride type"
                        );
                }

                Rider rider = new Rider("Rider");
                Driver driver = new Driver("Driver");

                Trip trip = new Trip(
                    rider, driver, vehicle, distance
                );

                System.out.printf("%.0f%n", trip.getFare());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid booking");
            }
        }

        sc.close();
    }
}
