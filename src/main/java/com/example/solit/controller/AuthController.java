package com.example.solit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.solit.entity.User;
import com.example.solit.model.UserModel;
//По результату успешно выполненной авторизации возвращаю данные авторизованного пользователя.
@Controller
//название сервера
//@RequestMapping("/start")
public class AuthController {
	//Контроллер принимает запрос и вызывает соответствующий служебный метод, основанный на GET или POST. 
	//Вызванный метод определяет данные Модели, основанные на определённой бизнес-логике и возвращает в DispatcherServlet имя Вида (View).
  
        
//        обработка конкретного урла  public String viewLoginPage()
        @GetMapping("/login")
        //все методы в данном Контроллере относятся к URL-адресу 
        //Контроллер обрабатывает запрос и создает модель. 
        //Front-контроллер заполняет представление данными модели и возвращает полученный результат браузеру
        //создается бин с названием метода вашем 
        public String  viewLoginPage() {
        	//имя предстовления формы 
            return "input";
        }
      
        
    }
     

