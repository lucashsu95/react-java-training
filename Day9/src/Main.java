
// import java.util.*;

import models.Card;
import models.Cash;
import models.Pay;
import routes.Api;
import seeders.MainSeeder;

/*water 折 2 元，最低 1 元；juice 二杯 8折
card 手續費 5 元 */
public class Main {
    public static int t = 0;
    public static Pay card = new Card(), cash = new Cash();

    // public static void Restock() {
    //     System.out.printf("water 庫存 %d, juice 庫存 %d\n", water.getAmount(), juice.getAmount());
    //     boolean f = false;
    //     while (!f) {
    //         String tmp = OutAndInput("進貨商品 (1:water, 2:juice, 0:取消)：");
    //         if (tmp.equals("1")) {
    //             water.addAmount(Integer.parseInt(OutAndInput("輸入 water 進貨數量：")));
    //             f = true;
    //             break;
    //         } else if (tmp.equals("2")) {
    //             juice.addAmount(Integer.parseInt(OutAndInput("輸入 juice 進貨數量：")));
    //             f = true;
    //             break;
    //         } else if (tmp.equals("0")) {
    //             System.out.println("動作取消");
    //             break;
    //         } else {
    //             System.out.println("輸入錯誤");
    //         }
    //     }
    //     if (f) {
    //         System.out.printf("water 庫存 %d, juice 庫存 %d\n", water.getAmount(), juice.getAmount());
    //     }
    // }

    // public static void SetPrice() {
    //     System.out.printf("water 價格 %d, juice 價格 %d\n", water.getPrice(), juice.getPrice());
    //     boolean f = false;
    //     while (!f) {
    //         String tmp = OutAndInput("更改價格 (1:water, 2:juice, 0:取消)：");
    //         if (tmp.equals("1")) {
    //             water.setPrice(Integer.parseInt(OutAndInput("設定 water 價格：")));
    //             f = true;
    //             break;
    //         } else if (tmp.equals("2")) {
    //             juice.setPrice(Integer.parseInt(OutAndInput("設定 juice 價格：")));
    //             f = true;
    //             break;
    //         } else if (tmp.equals("0")) {
    //             System.out.println("動作取消");
    //             break;
    //         } else {
    //             System.out.println("輸入錯誤");
    //         }
    //     }
    //     if (f) {
    //         System.out.printf("water 價格 %d, juice 價格 %d\n", water.getPrice(), juice.getPrice());
    //     }
    // }

    // public static boolean Pay(int price) {
    //     String tmp = "";
    //     while (true) {
    //         tmp = OutAndInput("付款方式 (1:卡片, 2:現金, 0:取消交易)：");

    //         if (tmp.equals("0")) {
    //             System.out.println("取消交易");
    //             return false;
    //         }
    //         if (tmp.equals("1")) {
    //             if (card.pay(price)) {
    //                 return true;
    //             }
    //         }
    //         if (tmp.equals("2")) {
    //             if (cash.pay(price)) {
    //                 return true;
    //             }
    //         } else {
    //             System.out.println("輸入錯誤");
    //         }
    //     }
    // }

    // public static void Sales() {
    //     String tmp = "";
    //     int buy = 0, total = 0;
    //     Product1 tmpP = null;
    //     boolean f = false;
    //     System.out.printf("water 剩餘 %d, juice 剩餘 %d\n", water.getAmount(), juice.getAmount());
    //     while (true) {
    //         tmp = OutAndInput("輸入購買物品 (1:water, 2:juice, 0:取消)：");
    //         if (tmp.equals("0")) {
    //             System.out.println("動作取消");
    //             break;
    //         } else if (tmp.equals("1")) {
    //             tmpP = water;
    //             f = true;
    //             break;
    //         } else if (tmp.equals("2")) {
    //             tmpP = juice;
    //             f = true;
    //             break;
    //         } else {
    //             System.out.println("輸入錯誤");
    //         }
    //     }

    //     if (f) {
    //         buy = Integer.parseInt(OutAndInput("輸入購買數量："));
    //         if (buy > tmpP.getAmount()) {
    //             System.out.println("庫存不足");
    //         } else if (buy > 0) {
    //             total = tmpP.sell(buy);
    //             if (Pay(total)) {
    //                 tmpP.sold(buy);
    //                 if (tmp.equals("1")) {
    //                     water = tmpP;
    //                 } else if (tmp.equals("2")) {
    //                     juice = tmpP;
    //                 }
    //             }
    //         }
    //         System.out.printf("water 剩餘 %d, juice 剩餘 %d\n", water.getAmount(), juice.getAmount());
    //     }
    // }

    public static void main(String[] args) {
        MainSeeder.main();
        Api.main();
    }

}