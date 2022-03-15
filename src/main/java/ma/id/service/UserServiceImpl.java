package ma.id.service;

import java.util.UUID;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.id.entities.Role;
import ma.id.entities.User;
import ma.id.repositories.RoleRepository;
import ma.id.repositories.UserRepository;

@Service
@Transactional @AllArgsConstructor
public class UserServiceImpl  implements UserService{

	
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    
	@Override
	public User addNewUser(User user) {
		user.setUserId(UUID.randomUUID().toString());		
		return userRepository.save(user);
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public User findUserByUsername(String name) {
		User user=userRepository.findByUsername(name);
		return user;
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		Role role=roleRepository.findByRoleName(roleName);
		return role;
	}

	@Override
	public void addRoleToUser(String roleName, String username) {
	   User user=findUserByUsername(username);
	   Role role=findRoleByRoleName(roleName);
	   if (user.getRoles()!=null) {user.getRoles().add(role);role.getUsers().add(user);}
	  // userRepository.save(user);
	   
		
	}

	@Override
	public User athenticated(String username, String password) {
		
		User user= findUserByUsername(username);
		if(user==null)new RuntimeException("Bad credential");
		
		if(user.getPassword().equals(password)) {
		return user;	
			
		} 
		throw new RuntimeException("Bad credential");
		
	
	}

}
