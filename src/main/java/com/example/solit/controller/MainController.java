package com.example.solit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//спринг на основании онотаций создает бин обьект.
//указывает Spring что это рест-контроллер обработка запроса 
@RestController
public class MainController {
	
	  @GetMapping("/")
	    public String homePage() {
	        return "home";
	    }
	
	
	
	//этот метод именно для GET запросов) и указали к методу путь 
	 @GetMapping("/unsecured")
    public String usecuredPage() {
        return "unsecured";
    }
}
