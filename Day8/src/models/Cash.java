package models;

import models.abstracts.Payment;

public class Cash extends Payment {
    public Cash() {
        super("現金", 1.0f);
    }

    public float pay(float price) {
        return price;
    }
}
