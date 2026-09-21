import java.util.Scanner;

abstract class Vehicle {
    String vehicleNumber;
    String brand;

    Vehicle(String vehicleNumber, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
    }

    abstract void startEngine();

    final void showVehicleIdentity() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Brand: " + brand);
    }
}

class Car extends Vehicle {
    Car(String no, String brand) {
        super(no, brand);
    }

    void startEngine() {
        System.out.println("Car engine starts");
    }
}

class Bike extends Vehicle {
    Bike(String no, String brand) {
        super(no, brand);
    }

    void startEngine() {
        System.out.println("Bike engine starts");
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Car Vehicle Number: ");
        String carNo = sc.nextLine();

        System.out.print("Enter Car Brand: ");
        String carBrand = sc.nextLine();

        Car car = new Car(carNo, carBrand);

        System.out.print("Enter Bike Vehicle Number: ");
        String bikeNo = sc.nextLine();

        System.out.print("Enter Bike Brand: ");
        String bikeBrand = sc.nextLine();

        Bike bike = new Bike(bikeNo, bikeBrand);

        System.out.println("\n--- Car Details ---");
        car.showVehicleIdentity();
        car.startEngine();

        System.out.println("\n--- Bike Details ---");
        bike.showVehicleIdentity();
        bike.startEngine();

        sc.close();
    }
}
