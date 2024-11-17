package seeders;

import java.util.Map;

import models.Boss;
import models.Customer;

public class UserSeeder {
    public static void main() {
        Boss.createBoss(Map.of("username", "admin", "password", "1234"));
        Customer.createCustomer(Map.of("username", "user1", "password", "user1pass"));
        Customer.createCustomer(Map.of("username", "user2", "password", "user2pass"));
        Customer.createCustomer(Map.of("username", "user3", "password", "user3pass"));
        Customer.createCustomer(Map.of("username", "user4", "password", "user4pass"));
        Customer.createCustomer(Map.of("username", "user5", "password", "user5pass"));
    }
}
