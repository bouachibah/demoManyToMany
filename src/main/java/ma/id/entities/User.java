package ma.id.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USERS")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
	@Id
	private String userId;
	@Column(name="USER_NAME" , unique = true, length = 20)
	private String username;
	private String password;
	@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
	private List<Role>roles =new ArrayList<>();// il fau t pas oublier d initialiser 

}
