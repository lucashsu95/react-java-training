package models;

import java.util.Scanner;

public class Cash implements Pay {

    @Override
    public boolean pay(int howMuch){
        int payn = 0, tmp = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.printf("輸入投入金額 (尚須%d元) (-1:取消交易)：", (howMuch-payn));
            tmp = Integer.parseInt(sc.nextLine());
            if (tmp == -1){
                System.out.printf("交易取消，退 %d 元。\n", payn);
                return false;
            }
            payn += tmp;
            if (payn>=howMuch){
                System.out.printf("交易成功，收您 %d 元，找您 %d 元\n", payn, (payn-howMuch));
                return true;
            }
        }
    }
}
