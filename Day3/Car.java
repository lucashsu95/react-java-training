public class Car {
    public String make;
    public String model;
    public int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void drive() {
        System.out.println("The " + this.make + " " + this.model + " is now being driven");
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2021);
        myCar.drive(); // Output: The Toyota Camry is now being driven

        SportsCar mySportsCar = new SportsCar("Porsche", "911", 2021);
        mySportsCar.drive(); // Output: The Porsche 911 is now being driven fast
        mySportsCar.drive(120); // Output: The Porsche 911 is now being driven at 120 mph
    }
}