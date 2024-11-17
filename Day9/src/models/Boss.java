package models;

import java.util.Map;

import store.Store;

public class Boss extends User {
    public Boss(String username, String password, String role) {
        super(username, password, role);
    }

    public static Boss createBoss(Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Boss boss = new Boss(username, password, "老闆");
        Store.users.add(boss);
        return boss;
    }
    
    @Override
    public String toPayload() {
        return String.format("帳號 %s 密碼 %s 角色 老闆", getUsername(), getPassword());
    }
}
