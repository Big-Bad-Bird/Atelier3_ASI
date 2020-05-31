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
	static final String urlCard = "http://localhost:8083/Card/ById/"; // + id carte
	
	// TODO Demander URL pour ça
	static final String urlUserMoneyGet = "http://localhost:8081/";
	static final String urlUserMoneyPut = "http://localhost:8081/";
	static final String urlUserCollection = "http://localhost:8081/";
	
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
		int moneyUser = restTemplate.getForObject(urlUserMoneyGet, int.class);
		int costCard = restTemplate.getForObject(urlCard, cardModel.class).getPrice();
		// collec + é
		
	}
	
	public void sell(String idUser, String idCard) {
		// TODO appels aux services USER associés
		// argent +
		// collec -
	}
	public List<cardModel> list() {
		CardListWrapper cardListWrapper = restTemplate.getForObject(urlAllCards, CardListWrapper.class);
		return cardListWrapper.cardList;
	}

}
