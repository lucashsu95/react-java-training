package products;

public class Product1 {
    int amount = 0, price = 0;

    public Product1(int amount, int price){
        this.amount = amount;
        this.price = amount;
    }

    public int sell(int amount){
        return 0;
    }

    public int getAmount(){
        return amount;
    }

    public int getPrice(){
        return price;
    }

    public void addAmount(int amount){
        this.amount += amount;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void sold(int n){
        this.amount -= n;
    }
}
