package com.example.solit.entity;
//JPA : Знакомство с технологией - 2ORM — это по сути концепция о том, что Java объект можно представить как данные в БД (и наоборот). 
//Она нашла воплощение в виде спецификации JPA — Java Persistence API.
import javax.persistence.*;


//ORM пользуется моделями данных для общения с БД. Но что, если модели захотелось поменять? Для этого программисты придумали миграции.
import java.util.List;
//сгенерировать сущьность персонаж в бд 
@Entity
@Table(name = "users")
//то связь между базой данной.
//записать в таблицу получить.обеспечивает основные операции по поиску, сохранения, удалению данных
//миграции это контроль изменеия версий базы данных и внисения изменений в базу внося новые поля(поле не меняется через entity нернерится новое)
//и колонки обновляем в пропертях spring.jpa.hibernate.ddl-auto=create
//Hibernate сущность, которая мапится на нашу таблицу, будет выглядеть так:
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
