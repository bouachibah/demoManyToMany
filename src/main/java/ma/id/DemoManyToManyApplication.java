package ma.id;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.id.entities.Role;
import ma.id.entities.User;
import ma.id.service.UserService;
import ma.id.service.UserServiceImpl;

@SpringBootApplication
public class DemoManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoManyToManyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(UserService userService) {
		return  new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				User u= new User();
				 u.setPassword("123456");
				 u.setUsername("abdelkrim");
				 userService.addNewUser(u);
				 User u1= new User();
				 u1.setPassword("123456");
				 u1.setUsername("abdel");
				 userService.addNewUser(u1);
				 Stream.of("STUDENT","USER" ,"ADMIN").forEach(r->{
					 Role role=new Role();
					 role.setRoleName(r);
					 role.setDesc("role "+r+" n est pas utilise ");
					 userService.addRole(role); 
					 
				 });
				  userService.addRoleToUser("STUDENT", "abdelkrim");
				  userService.addRoleToUser("USER", "abdel");
				  userService.addRoleToUser("ADMIN", "abdelkrim");
				   
				System.out.println("********************************");
				  try {
					 User user= userService.athenticated("abdelkrim", "123456");
					  System.out.println("je me suis bien connecté "+user.getPassword());
					  user.getRoles().forEach(r->{
						  System.out.println(r);
					  });
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				 
				  
				
				 
				 
				
			}
		};
	} 

}
