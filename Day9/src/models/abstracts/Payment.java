package models.abstracts;

import models.ApplePay;
import models.LinePay;

public abstract class Payment {
    private String name;
    private int discount;

    public Payment(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public static Payment createPayment(String className) {
        switch (className) {
            case "1":
                return new LinePay("Line Pay", 10);
            case "0":
                return new ApplePay("Apple Pay", 20);
            default:
                return null;
        }
    }

    public abstract float pay(float price);
}
