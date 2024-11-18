package controllers;

import models.abstracts.User;
import store.Store;

import static store.Store.currentUser;
import static lib.Functions.OutAndInput;

public class AuthController {
    // middleware Start

    public static boolean hasLogin() {
        return !(Store.currentUser.get("token") == null);
    }

    public static boolean checkPermission() {
        boolean hasPermission = currentUser.get("role").equals("老闆");
        if (!hasPermission) {
            System.out.println("權限不足");
            return false;
        }
        return true;
    }

    public static User checkHasUser(String username) {
        for (int i = 0; i < Store.users.size(); i++) {
            if (Store.users.get(i).getUsername().equals(username)) {
                return Store.users.get(i);
            }
        }
        return null;
    }
    // middleware End

    public static void login() {
        String username = OutAndInput("輸入帳號：");
        User user = checkHasUser(username);
        if (user == null) {
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

    public static void logout() {
        if (!hasLogin()) {
            System.out.println("尚未登入");
            return;
        }
        currentUser.put("username", null);
        currentUser.put("role", null);
        currentUser.put("token", null);
        System.out.println("登出成功");
    }
}
