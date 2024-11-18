package models;

import models.abstracts.Payment;

public class LinePay extends Payment {

    public LinePay(float discount) {
        super("Line Pay", discount);
    }

    public float pay(float price) {
        float discountedPrice = price * getDiscount();
        return Math.round(discountedPrice);
    }
}
