package  com.example.solit.repository;
// интерфейс Это совокупность абстрактных методов.
//множественного наследования в Java нет. А вот множественная реализация интерфейсов — есть. Класс может реализовывать сколько угодно интерфейсов.
//Интерфейсы определяют некоторый функционал, не имеющий конкретной реализации, который затем реализуют классы, применяющие эти интерфейсы.
import  com.example.solit.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
//CrudRepository имеет набор базовых методов для работы с сущностью,
//названия которых говорят сами за себя:
public interface UserRepo extends CrudRepository<UserEntity, Long> {
	//отдает метод сервису 
    UserEntity findByUsername(String username);
}
//Основное понятие в Spring Data — это репозиторий. Это несколько интерфейсов которые используют JPA
//Entity для взаимодействия с ней.