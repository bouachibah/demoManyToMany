package ma.id.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column( unique = true, length = 20)
	private String roleName;
	private String desc;
	@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name="USERS_ROLES")
	@ToString.Exclude
	private List<User>users=new ArrayList<>();
	

}
