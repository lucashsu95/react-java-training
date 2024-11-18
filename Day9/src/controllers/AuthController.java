package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Customer;
import store.Store;

import static store.Store.currentUser;
import static lib.Functions.OutAndInput;

public class AuthController {
    public static boolean checkLogin() {
        return !(Store.currentUser.get("token") == null);
        // 時間不足，未實作token機制
    }

    public static boolean checkPermission() {
        return currentUser.get("role").equals("老闆");
    }

    public static void login() {
        String username = OutAndInput("輸入帳號：");
        String password = OutAndInput("輸入密碼：");
        for (int i = 0; i < Store.users.size(); i++) {
            if (Store.users.get(i).getUsername().equals(username)
                    && Store.users.get(i).getPassword().equals(password)) {
                currentUser.put("username", username);
                currentUser.put("role", Store.users.get(i).getRole());
                currentUser.put("token", "token");
                System.out.println("登入成功");
                return;
            }
        }
        System.out.println("登入失敗");
    }

    public static void signUp() {
        String username = OutAndInput("輸入帳號：");
        String password = OutAndInput("輸入密碼：");

        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);

        Customer.createCustomer(credentials);
        System.out.println("新增使用者成功");
    }

    public static void logout() {
        currentUser.put("username", null);
        currentUser.put("role", null);
        currentUser.put("token", null);
        System.out.println("登出成功");
    }
}
