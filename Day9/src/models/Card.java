package models;

public class Card implements Pay {

    @Override
    public boolean pay(int howMuch){
        System.out.printf("交易成功，收您 %d元\n", howMuch+5);
        return true;
    }
}
