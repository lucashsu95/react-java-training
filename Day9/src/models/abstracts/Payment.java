package models.abstracts;

public abstract class Payment {
    private String name;
    private float discount;

    public Payment(String name, float discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public abstract float pay(float price);
}
