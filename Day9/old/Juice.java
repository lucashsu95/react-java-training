package products;

public class Juice extends Product1 {
    public Juice(int amount, int price){
        super(amount, price);
        super.amount = amount;
        super.price = price;
    }

    @Override
    public int sell(int amount){
        int total = amount%2 * super.price + (int)(Math.round(amount/2 * super.price * 0.8)) ;
        return total;
    }
}
