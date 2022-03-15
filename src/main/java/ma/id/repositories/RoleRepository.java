package ma.id.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.id.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRoleName(String roleName);

}
