package Day2and3;

class Vehicle {
    int speed;
    String fuelType;

    Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    void displayDetails() {
        System.out.println("Speed: " + speed + " km/h, Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int numDoors;

    Car(int speed, String fuelType, int numDoors) {
        super(speed, fuelType);
        this.numDoors = numDoors;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numDoors);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(int speed, String fuelType, int numDoors, int batteryCapacity) {
        super(speed, fuelType, numDoors);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class Main {
    public static void main(String[] args) {
        ElectricCar ec = new ElectricCar(60, "Diesel", 4, 5000);
        ec.displayDetails();
    }
}
