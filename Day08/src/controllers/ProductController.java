package controllers;

import static lib.Const.getPaymentTip;
import static lib.Functions.OutAndInput;
import static store.Store.products;

import lib.Functions;
import models.Product;
import models.abstracts.Payment;

public class ProductController {
    // middleware Start
    public static Product checkHasProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        System.out.println("找不到商品");
        return null;
    }
    // middleware End

    public static void printProduct() {
        String displayString = "商品資訊：\n";
        for (Product product : products) {
            displayString += product.getInfo() + "\n";
        }
        System.out.println(displayString);
    }

    public static void addProduct() {
        String name = OutAndInput("輸入商品名稱：");
        int amount = Integer.parseInt(OutAndInput("輸入商品庫存："));
        int price = Integer.parseInt(OutAndInput("輸入商品價格："));

        Product product = new Product(name, amount, price);
        products.add(product);
        System.out.println("新增商品成功");
    }

    public static void updateProduct() {
        printProduct();
        String name = OutAndInput("輸入想要修改的商品名稱：");
        Product product = checkHasProduct(name);
        if (product == null) {
            return;
        }
        int amount = Integer.parseInt(OutAndInput("輸入商品庫存："));
        int price = Integer.parseInt(OutAndInput("輸入商品價格："));
        product.setAmount(amount);
        product.setPrice(price);
        System.out.println("修改商品成功");

    }

    public static void deleteProduct() {
        printProduct();
        String name = OutAndInput("輸入商品名稱：");
        Product product = checkHasProduct(name);
        if (product == null) {
            return;
        }
        products.remove(product);
        System.out.println("刪除商品成功");

    }

    public static void buyProduct() {
        printProduct();
        String name = OutAndInput("輸入商品名稱：");
        Product product = checkHasProduct(name);
        if (product == null) {
            return;
        }

        int amount = Integer.parseInt(OutAndInput("輸入購買數量："));
        if (product.getAmount() >= amount) {
            product.setAmount(product.getAmount() - amount);
            System.out.println("輸入付款方式：");
            String usePayment = OutAndInput(getPaymentTip());
            Payment currentPayment = Functions.createPayment(usePayment);
            if (currentPayment == null) {
                System.out.println("找不到付款方式");
                return;
            }

            float price = product.getPrice() * amount;
            float discountedPrice = currentPayment.pay(price);

            System.out.println("總價: " + price);
            System.out.println("使用 " + currentPayment.getName() + " 付款");
            System.out.println("原價: " + price + " 折扣後價格: " + discountedPrice);
            System.out.println("購買成功");
            return;
        } else {
            System.out.println("庫存不足");
            return;
        }
    }

}
