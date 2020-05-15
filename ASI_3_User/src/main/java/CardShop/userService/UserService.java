package CardShop.userService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CardShop.userService.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	public User createUser(User newUser) {
		User u = new User();
		u.setName(newUser.getName());
		u.setUsername(newUser.getUsername());
		u.setPassword(newUser.getPassword());
		u.setArgent(10000);
		System.out.println("\nCREATE USER");
		uRepo.save(u);
		
		return u;		
	}
	
	public User getUserInfo(Integer userId) {
		if(uRepo.findById(userId).isPresent()) {
			User userToFind = uRepo.findById(userId).get();
			System.out.println("\nUSER TO FIND => "+userToFind);
			return userToFind;
		}
		return null;
	}
	
	public Iterable<User> getAllUser(){
		ArrayList<User> uList = new ArrayList<User>();
		Iterable<User> uIter = uRepo.findAll();
		return uIter;
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		User userFound = uRepo.findByUsernameAndPassword(username, password);
		System.out.println("\nTHIS USER => "+userFound);
		return userFound;
	}
	
	public User getUserMoney(String username) {
		if(uRepo.findByUsername(username).isPresent()) {
			User userToFind = uRepo.findByUsername(username).get();
			System.out.println("\nUSER TO FIND => "+userToFind);
			return userToFind;
		}
		return null;
	}

}
