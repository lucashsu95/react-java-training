package com.example.accessing_data_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 這表示這個類別是一個 Controller
@RequestMapping(path = "/demo") // 這表示 URL 的起始路徑是 /demo（在應用程序路徑之後）
public class MainController {
  @Autowired // 這表示要獲取名為 userRepository 的 bean
  // 這是由 Spring 自動生成的，我們將使用它來處理數據
  private UserRepository userRepository;

  @PostMapping(path = "/add") // 僅映射 POST 請求
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
    // @ResponseBody 表示返回的 String 是響應，不是視圖名
    // @RequestParam 表示它是一個來自 GET 或 POST 請求的參數

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // 這返回一個包含用戶的 JSON 或 XML
    return userRepository.findAll();
  }
}
