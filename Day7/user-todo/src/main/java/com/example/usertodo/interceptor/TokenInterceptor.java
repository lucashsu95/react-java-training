package com.example.usertodo.interceptor;

import com.example.usertodo.Repository.UserRepository;
import com.example.usertodo.annotation.RequireToken;
import com.example.usertodo.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final UserRepository userRepository;

    public TokenInterceptor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        RequireToken requireToken = handlerMethod.getMethodAnnotation(RequireToken.class);

        if (requireToken == null) {
            return true;
        }

        String header = request.getHeader("Authorization");

        String[] parts = header.split(" ");
        if (parts.length == 2 && "Bearer".equals(parts[0])) {
            String token = parts[1];
            Optional<User> isExists = userRepository.findByAccessToken(token);
            if(isExists.isPresent()) {
                return true;
            }
        }

        response.setStatus(401);
        return false;
    }
}