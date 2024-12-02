
package models.abstracts;

public interface PaymentInterface {
    String getName();
    float getDiscount();
    float pay(float price);
}