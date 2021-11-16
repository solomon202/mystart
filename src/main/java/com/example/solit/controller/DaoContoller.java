package com.example.solit.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.solit.entity.User;
import com.example.solit.service.UserService;

import java.security.Principal;
//спринг на основании онотаций создает бин обьект.
//указывает Spring что это рест-контроллер обработка запроса 
@RestController
@Profile("dao")
@Slf4j
public class DaoContoller {

//сылка на класс конкретный который обрабатывает запрос 
    private UserService userService;
//запрос обрабатывается конкреными  методами  передаете состояние, а не храните его на сервере.
//В REST вообще не существует Model и View. Есть только данные, поставляемые контроллером, и представление ресурса,
//когда сообщение конвертируется из медиа-типа(json, xml...) в объект.
// Она указывает, что этот класс оперирует не моделями, а данными.
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
  //этот метод именно для GET запросов) и указали к методу путь 
    @GetMapping("/dao")
    public String daoTestPage(Principal principal) {
        // Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : " + user.getEmail();
    }
}
