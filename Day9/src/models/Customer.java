package models;

import java.util.Map;

import store.Store;

public class Customer extends User {
    public Customer(String username, String password, String role) {
        super(username, password, role);
    }

    public static Customer createCustomer(Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Customer customer = new Customer(username, password, "顧客");
        Store.users.add(customer);
        return customer;
    }

    @Override
    public String toPayload() {
        return String.format("帳號 %s 密碼 %s 角色 顧客", getUsername(), getPassword());
    }
}
