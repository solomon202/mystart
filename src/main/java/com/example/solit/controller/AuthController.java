package com.example.solit.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.solit.entity.User;
import com.example.solit.model.UserModel;
//По результату успешно выполненной авторизации возвращаю данные авторизованного пользователя.
//анотации создают обьекты оживляя их говоря сервису спринг создает обьекты
@Controller
//название сервера
//@RequestMapping("/start")
public class AuthController {
	//Контроллер принимает запрос и вызывает соответствующий служебный метод, основанный на GET или POST. 
	//Вызванный метод определяет данные Модели, основанные на определённой бизнес-логике и возвращает в DispatcherServlet имя Вида (View).
  
	//для отправки данных на сайт
	@PostMapping(value = "/number")
	//модель передается методу в виде параметра.
	public String simpleModel1(Model model) {
		model.addAttribute("number");
		return "number";
	}

	
	//для доступа к указанной странице
	  @GetMapping("/regist")
      public String  view() {
      	//имя предстовления формы 
          return "regist";
      }
	  
	  
	  
	  
//        обработка конкретного урла  public String viewLoginPage()
        @GetMapping("/shop")
        //все методы в данном Контроллере относятся к URL-адресу 
        //Контроллер обрабатывает запрос и создает модель. 
        //Front-контроллер заполняет представление данными модели и возвращает полученный результат браузеру
        //создается бин с названием метода вашем 
        public String  viewLoginPage() {
        	//имя предстовления формы 
            return "sushi";
        }
        
    }
     

