package models;

import models.abstracts.Payment;

public class ApplePay extends Payment {

    public ApplePay(float discount) {
        super("ApplyPay", discount);
    }

    public float pay(float price) {
        float discountedPrice = price * getDiscount();
        return Math.round(discountedPrice);
    }
}
