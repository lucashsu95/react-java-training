public class SportsCar extends Car {
    public SportsCar(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void drive() {
        System.out.println("The " + this.make + " " + this.model + " is now being driven fast");
    }

    public void drive(int speed) {
        System.out.println("The " + this.make + " " + this.model + " is now being driven at " + speed + " mph");
    }
}
