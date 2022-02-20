package com.example.solit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.solit.service.PersonDAO;
import com.example.solit.model.Person;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
// создаём обьект вставляем методв его параметры другой обьект и
    //в теле вытаскиваем сылки
    @GetMapping()
   // Model (модель). Получает данные от контроллера, выполняет необходимые 
    //операции и передаёт их в вид. View (вид или представление).
    //модель бд для передачи её в модель html
    public String index(Model model) {
//     связь бд	получить индекс и вставвит в форму 
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
   //получить по айди 
    @GetMapping("/{id}")
    // @RequestParam используется для получения параметров запроса из URL
    //String getParameter (String name) Возвращает значение параметра запроса в виде String или null, если параметр не существует. Параметры запроса
    //- это дополнительная информация, отправляемая вместе с запросом.
    //@PathVariable извлекает значения из URI.
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
     //получитьстраницу
    @GetMapping("/new")
    //Он помещает в модель компонент, созданный кодом пользователя, 
    //и всегда вызывается перед методом обработки запроса.
    //@ModelAttribute("person") модель и её отребуты которые переходят в обьект персона
    //происходит, так это то, что он получает все значения вашей формы, которые были переданы им, 
    //а затем хранит их, чтобы вы могли связать или присвоить их объекту.
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    // взять атребуты модели и сохранение в базу 
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
