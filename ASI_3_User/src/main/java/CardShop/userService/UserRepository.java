package CardShop.userService;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import CardShop.userService.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query(nativeQuery = true,
			value = "SELECT * "
					+ "FROM User as u "
					+ "WHERE u.username = :username "
					+ "AND u.password = :password ")
	User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	Optional<User> findByUsername(String username);

}
