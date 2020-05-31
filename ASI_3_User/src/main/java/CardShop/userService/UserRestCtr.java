package CardShop.userService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserRestCtr {

	
	private User currentUser;
	
	@Autowired
	UserService uService;
	
	@RequestMapping("/caboum")
	public String CaBoum() {
		return "Ca boum ?";
	}
	
//	@RequestMapping("/testuserobj")
//	public User testUserObj(){
//		User u = new User();
//		u.setName("lucie");
//		u.setSurname("limace44");
//		u.setPassword("psw");
//		return u;
//	}
	
	@PostMapping("/create-user")
	public User userService(@RequestBody User newUser) {
		System.out.println("\nEntrée dans create-user");
		try {
			User u = uService.createUser(newUser);
			return u;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/user-info/{userId}")
	public User getUserInfo(@PathVariable("userId") Integer userId) {
		try {
			User u = uService.getUserInfo(userId);
			return u;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/getm-username/{username}")
	public Integer getMoney(@PathVariable("username") String username) {
		try {
			User u = uService.getUserMoney(username);
			return u.getArgent();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/getusercards/{username}")
	public Set<CardModel> getUserCards(@PathVariable("username") String username){
		try {
			return uService.getUserCards(username);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/allusers")
	public Iterable<User> getAllUser(){
		return uService.getAllUser();
	}
	
	@PostMapping("/verif-login")
	public User checkUser(@RequestBody User user) {
		System.out.println("Passage dans verif-login");
		User userFound = uService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		this.currentUser = userFound;
		System.out.println("\nTHIS.CURRENTUSER = " + this.currentUser +"\n");
//		return new ResponseEntity<User>(userFound, HttpStatus.FOUND);
		return userFound;
	}
	
	@PutMapping("/addCardCollec/{username}")
	public void addCardList(@PathVariable("username") String username, @RequestBody Set<CardModel> cardstoadd){
		uService.addCard(cardstoadd, username);
	}
	
	@PutMapping("/delCardCollec/{username}")
	public void delCardList(@PathVariable("username") String username, @RequestBody Set<CardModel> cardstodel){
		uService.deleteCard(cardstodel, username);
	}
	
	@PutMapping("/updatemoney/{username}")
	public int updateMoney(@PathVariable("username") String username, @RequestParam("delta") int delta) { //delta = signed int
		return uService.updateUsermoney(delta, username);
	}
	
	

}
