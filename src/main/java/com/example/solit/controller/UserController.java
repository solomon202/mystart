package com.example.solit.controller;

import com.example.solit.entity.UserEntity;
import com.example.solit.exception.UserAlreadyExistException;
import com.example.solit.exception.UserNotFoundException;
import com.example.solit.repository.UserRepo;
import com.example.solit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//обработка запроса
//чтобы спринг понимал что это контролеер 
@RestController
//запрос который он должен обработать
@RequestMapping("/users")
public class UserController {

@Autowired
//сылка на класс 
private UserService userService;
//запрос обрабатывается конкреными  методами  передаете состояние, а не храните его на сервере.
//В REST вообще не существует Model и View. Есть только данные, поставляемые контроллером, и представление ресурса,
//когда сообщение конвертируется из медиа-типа(json, xml...) в объект.
// Она указывает, что этот класс оперирует не моделями, а данными.
@PostMapping
//вызов метода класса вставить 
public ResponseEntity registration(@RequestBody UserEntity user) {
    try {
//    	вызвать  сылку конкретный метод 
        userService.registration(user);
        return ResponseEntity.ok("Пользователь успешно сохранен");
    } catch (UserAlreadyExistException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Произошла ошибка");
    }
}


@GetMapping
public ResponseEntity getOneUser(@RequestParam Long id) {
    try {
        return ResponseEntity.ok(userService.getOne(id));
    } catch (UserNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Произошла ошибка");
    }
}

@DeleteMapping("/{id}")
public ResponseEntity deleteUser(@PathVariable Long id) {
    try {
        return ResponseEntity.ok(userService.delete(id));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Произошла ошибка");
    }
}
}
