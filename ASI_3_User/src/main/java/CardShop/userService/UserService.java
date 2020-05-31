package CardShop.userService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	CardModelRepository CMRepo;
	
	public User createUser(User newUser) {
		User u = new User();
		u.setName(newUser.getName());
		u.setUsername(newUser.getUsername());
		u.setPassword(newUser.getPassword());
		u.setArgent(10000);
		getCardinit();
		List<CardModel> allcards = getAllCards();
		System.out.println("\nTHIS IS getAllCards de mon rest template :" + allcards + "\n");
		Set<CardModel> myfilledcollec = fillCollection(allcards);
		System.out.println("\nTHIS IS fillCollection(getAllCards()) de ma méthode : " + fillCollection(allcards) + "\n");
		u.setCollection(myfilledcollec);
		//u.setCollection(fillCollection(getAllCards()));
		System.out.println("\nCREATE USER : " + u + "\n");
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
	
	public Set<CardModel> getUserCards(String username){
		if(uRepo.findByUsername(username).isPresent()) {
			User userToFind = uRepo.findByUsername(username).get();
			System.out.println("\nLes cartes de l'utilisateur " + username + " sont les suivantes :" + userToFind.getCollection());
			return userToFind.getCollection();
		}
		return null;
	}
	
	private Set<CardModel> fillCollection(List<CardModel> allcardslist){
		Set<CardModel> mescartes = new HashSet<CardModel>();
		for(CardModel c : allcardslist) {
			CMRepo.save(c);
			mescartes.add(c);
		}
		return mescartes;
	}
	
	public void addCard(Set<CardModel> cardstoadd, String username){
		User userToFind = uRepo.findByUsername(username).get();
		Set<CardModel> mycollection = userToFind.getCollection();
		for(CardModel c : cardstoadd) {
			mycollection.add(c);
		}
		userToFind.setCollection(mycollection);
		uRepo.save(userToFind);
	}
	
	public void deleteCard(Set<CardModel> cardstodel, String username) {
		User userToFind = uRepo.findByUsername(username).get();
		Set<CardModel> mycollection = userToFind.getCollection();
		for(CardModel c : cardstodel) {
			mycollection.remove(c);
		}
		userToFind.setCollection(mycollection);
		uRepo.save(userToFind);
	}
	
	public int updateUsermoney(int delta, String username) {
		User userToFind = uRepo.findByUsername(username).get();
		int mymoney = userToFind.getArgent();
		mymoney = mymoney + delta;
		userToFind.setArgent(mymoney);
		uRepo.save(userToFind);
		return userToFind.getArgent();
	}
	
//REST TEMPLATE
	
	private void getCardinit() {
		RestTemplate restTemplate = new RestTemplate();
		String CardinitURL
		  = "http://localhost:8083/Card/init";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(CardinitURL, String.class);
//		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	private List<CardModel> getAllCards() {
		RestTemplate restTemplate = new RestTemplate();
		String AllCardsURL
		  = "http://localhost:8083/Card/getAllCards";
//		ResponseEntity<List<CardModel>> response
//		  = restTemplate.getForEntity(AllCardsURL, List<CardModel>);
		ResponseEntity<List<CardModel>> response
		  = restTemplate.exchange(AllCardsURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<CardModel>>(){});
		System.out.println("\nTHIS IS MY RESPONSEBODY :" + response.getBody() + "\n");
		return response.getBody();
	}
	
	

}
