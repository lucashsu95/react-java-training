package seeders;

import models.Product;
import store.Store;

public class ProductSeeder {
    public static void main() {
        Store.products.add(new Product("water", 10, 10));
        Store.products.add(new Product("juice", 10, 15));
    }
}
