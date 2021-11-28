package com.example.solit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//По результату успешно выполненной авторизации возвращаю данные авторизованного пользователя.
@Controller
//название сервера
@RequestMapping("/start")
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
