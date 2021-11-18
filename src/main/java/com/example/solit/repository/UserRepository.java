package com.example.solit.repository;

//интерфейс который взаимодеиствует с базой и далее с сущьностью
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.solit.entity.User;

import java.util.Optional;
// интерфейс Это совокупность абстрактных методов.
@Repository
@Profile("dao")
//CrudRepository имеет набор базовых методов для работы с сущностью,
//названия которых говорят сами за себя:
public interface UserRepository extends CrudRepository<User, Long> {
//отдает метод сервису распарсит хочу искать по имени пользователя 
    Optional<User> findByUsername(String username);
}
//Основное понятие в Spring Data — это репозиторий. Это несколько интерфейсов которые используют JPA
//Entity для взаимодействия с ней.как один механизм с другим
