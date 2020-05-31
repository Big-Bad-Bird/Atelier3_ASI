package Market.springbootstarter.market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

// https://o7planning.org/fr/11647/exemple-spring-boot-restful-client-avec-resttemplate#a13901576

@Service
public class marketService {

	static final String urlAllCards = "http://localhost:8083/Card/getAllCardsWrapper";
	
	// TODO Demander URL pour ça
	final String urlUserMoneyGet = "http://localhost:8081/";
	final String urlUserMoneyPut = "http://localhost:8081/";
	final String urlUserCollection = "http://localhost:8081/";
	
	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private marketRepository market;
	public marketService() {
		// TODO Auto-generated constructor stub
	}
	public void buy(String idUser, String idCard) {
		// TODO appels aux services USER associés
		// argent - étape 1 demander argent étape 2 demander coût 3 changer argent
		
		final String urlUserMoneyGetId = this.urlUserMoneyGet + idUser;
		int moneyUser = restTemplate.getForObject(urlUserMoneyGetId, int.class);
		
		final String urlCardId = "http://localhost:8083/Card/ById/" + idCard;
		int costCard = restTemplate.getForObject(urlCardId, cardModel.class).getPrice();
		
		int newMoneyValue = moneyUser - costCard;
		// envoyer nouvelle valeur argent
		
		// collec +
		
	}
	
	public void sell(String idUser, String idCard) {
		// TODO appels aux services USER associés
		final String urlUserMoneyGetId = this.urlUserMoneyGet + idUser;
		int moneyUser = restTemplate.getForObject(urlUserMoneyGetId, int.class);
		
		final String urlCardId = "http://localhost:8083/Card/ById/" + idCard;
		int costCard = restTemplate.getForObject(urlCardId, cardModel.class).getPrice();
		
		int newMoneyValue = moneyUser + costCard;
		// envoyer nouvelle valeur argent
		
		// collec -
		
	}
	public List<cardModel> list() {
		CardListWrapper cardListWrapper = restTemplate.getForObject(urlAllCards, CardListWrapper.class);
		return cardListWrapper.cardList;
	}

}
