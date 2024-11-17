package products;

public class Water extends Product1 {
    public Water(int amount, int price){
        super(amount, price);
        super.amount = amount;
        super.price = price;
    }

    @Override
    public int sell(int amount){
        int total = amount * Math.max((super.price - 2), 1) ;
        return total;
    }
}
