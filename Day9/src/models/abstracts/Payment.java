package models.abstracts;

public abstract class Payment implements PaymentInterface {
    private String name;
    private float discount;

    public Payment(String name, float discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public float getDiscount() {
        return discount;
    }

    public abstract float pay(float price);
}
