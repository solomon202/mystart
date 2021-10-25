package com.example.solit.entity;
//JPA : Знакомство с технологией - 2ORM — это по сути концепция о том, что Java объект можно представить как данные в БД (и наоборот). 
//Она нашла воплощение в виде спецификации JPA — Java Persistence API.
import javax.persistence.*;
import java.util.List;
//сгенерировать сущьность персонаж
@Entity
@Table(name = "user")
//Hibernate сущность, которая мапится на нашу таблицу, будет выглядеть так:
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
//связь с другой таблицей удаление всех таблиц при стирании пользователя 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
