import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    double rentPerDay;

    Vehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 0.90;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 1.20;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int type = sc.nextInt();
            String vehicleNumber = sc.next();
            double rentPerDay = sc.nextDouble();
            int days = sc.nextInt();

            Vehicle vehicle;

            if (type == 1) {
                vehicle = new Car(vehicleNumber, rentPerDay);
            } else if (type == 2) {
                vehicle = new Bike(vehicleNumber, rentPerDay);
            } else {
                vehicle = new Truck(vehicleNumber, rentPerDay);
            }

            double totalRent = vehicle.calculateRent(days);

            System.out.printf("%s %.2f%n",
                    vehicleNumber, totalRent);
        }

        sc.close();
    }
}
