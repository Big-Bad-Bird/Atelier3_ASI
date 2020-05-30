package CardShop.userService;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String username;
	private String password;
	private Integer argent;
	@OneToMany()
	private Set<CardModel> collection; //Liste des cartes poss�d�es par l'utilisateur
	
	public User () {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArgent() {
		return argent;
	}

	public void setArgent(Integer argent) {
		this.argent = argent;
	}
	

	public Set<CardModel> getCollection() {
		return collection;
	}

	public void setCollection(Set<CardModel> collection) {
		this.collection = collection;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", argent="
				+ argent + ", collection=" + collection + "]";
	}
		

}
