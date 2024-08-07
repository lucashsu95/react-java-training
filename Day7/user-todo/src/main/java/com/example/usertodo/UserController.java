package com.example.usertodo.controller;

import com.example.usertodo.dto.ApiResponse;
import com.example.usertodo.dto.ErrorCode;
import com.example.usertodo.model.User;
import com.example.usertodo.service.UserService;
import com.example.usertodo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<Iterable<User>>> index() {
        return ResponseUtil.success(userService.index());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> insert(@RequestBody User user) {
        return ResponseUtil.success(userService.insert(user));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<?>> update(@PathVariable Long id, @RequestBody User user) {
//        Optional<User> updatedUser = userService.update(id, user);
//        return updatedUser.map(ResponseUtil::success)
//                .orElseGet(() -> ResponseUtil.fail(ErrorCode.USER_EXISTS, HttpStatus.NOT_FOUND));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> update(@PathVariable Long id, @RequestBody User user) {
        Optional<User> updatedUser = userService.update(id, user);
        return updatedUser.map(u -> ResponseUtil.success((Object) u))
                .orElseGet(() -> ResponseUtil.fail(ErrorCode.USER_EXISTS, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> destroy(@PathVariable Long id) {
        if (userService.destroy(id)) {
            return ResponseUtil.success();
        }
        return ResponseUtil.fail(ErrorCode.USER_EXISTS, HttpStatus.NOT_FOUND);
    }
}