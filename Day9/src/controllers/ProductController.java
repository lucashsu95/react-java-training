package controllers;

import static lib.Functions.OutAndInput;
import static store.Store.products;

import models.Product;

public class ProductController {
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
        for (Product product : products) {
            if (product.getName().equals(name)) {
                int amount = Integer.parseInt(OutAndInput("輸入商品庫存："));
                int price = Integer.parseInt(OutAndInput("輸入商品價格："));
                product.setAmount(amount);
                product.setPrice(price);
                System.out.println("修改商品成功");
                return;
            }
        }
        System.out.println("找不到商品");
    }

    public static void deleteProduct() {
        printProduct();
        String name = OutAndInput("輸入商品名稱：");
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                System.out.println("刪除商品成功");
                return;
            }
        }
        System.out.println("找不到商品");
    }
}
