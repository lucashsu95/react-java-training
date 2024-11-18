package store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Product;
import models.abstracts.User;

public class Store {
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static Map<String, String> currentUser = new HashMap<String, String>() {
        {
            put("username", null);
            put("role", null);
            put("token", null);
        }
    };

    public class users {
    }
}
