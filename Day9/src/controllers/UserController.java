package controllers;

import store.Store;

import static lib.Functions.OutAndInput;

import java.util.HashMap;
import java.util.Map;

import models.Boss;
import models.Customer;
import models.abstracts.User;

public class UserController {

    public static void printAllUser() {
        for (User user : Store.users) {
            System.out.println(user.toPayload());
        }
    }

    public static void addUser() {
        String username = OutAndInput("輸入帳號：");
        String password = OutAndInput("輸入密碼：");
        String role = OutAndInput("輸入角色(1:老闆,2:顧客)：");

        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);

        if (role.equals("1")) {
            Boss.createBoss(credentials);
        } else if (role.equals("2")) {
            Customer.createCustomer(credentials);
        }
        System.out.println("新增使用者成功");
    }
}
