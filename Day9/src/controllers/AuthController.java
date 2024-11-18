package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Customer;
import models.abstracts.User;
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

    public static User checkHasUser(String username) {
        for (int i = 0; i < Store.users.size(); i++) {
            if (Store.users.get(i).getUsername().equals(username)) {
                return Store.users.get(i);
            }
        }
        return null;
    }

    public static void login() {
        String username = OutAndInput("輸入帳號：");
        User user = checkHasUser(username);
        if(user == null){
            System.out.println("帳號不存在");
            return;
        }
        String password = OutAndInput("輸入密碼：");
        if (user.getPassword().equals(password)) {
            currentUser.put("username", username);
            currentUser.put("role", user.getRole());
            currentUser.put("token", "token");
            System.out.println("登入成功");
            return;
        }
        System.out.println("登入失敗");
    }

    public static void signUp() {
        String username = OutAndInput("輸入帳號：");
        if (checkHasUser(username) != null) {
            System.out.println("帳號已存在");
            return;
        }
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
