package ma.id.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.id.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String userName);

}
