package ma.id.service;

import ma.id.entities.Role;
import ma.id.entities.User;

public interface UserService {

	User addNewUser(User user);//qui permet d ajouter un utilisateur
	Role addRole(Role role);  //qui permet  d ajouter un role 
	User findUserByUsername(String name);// permet de chercher un user à partir de son username 
	Role findRoleByRoleName(String roleName); //permet de trouver un role a partir de son nom
	void addRoleToUser(String roleName,String username);// dans ce cas on suppose que le username est unique
	//je cree une methode qui permet d authentifier un user
	User athenticated(String username, String password);
	
	
	
}
