package models;

import models.abstracts.Payment;

public class LinePay extends Payment {

    public LinePay(String name, int discount) {
        super(name, discount);
    }

    public float pay(float price) {
        float discountedPrice = price * (1 - (getDiscount() / 100.0f));
        return Math.round(discountedPrice);
    }
}
