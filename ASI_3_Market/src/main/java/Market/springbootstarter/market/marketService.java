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
	
	// TODO Demander URL pour �a
	final String urlUserMoneyGet = "http://localhost:8081/";
	final String urlUserMoneyPut = "http://localhost:8081//updatemoney/";
	final String urlUserCollection = "http://localhost:8081/";
	
	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private marketRepository market;
	public marketService() {
		// TODO Auto-generated constructor stub
	}
	public void buy(String idUser, String idCard) {
		// TODO appels aux services USER associ�s
			final String urlUserMoneyGetId = this.urlUserMoneyGet + idUser;
			int moneyUser = restTemplate.getForObject(urlUserMoneyGetId, int.class);
			
			final String urlCardId = "http://localhost:8083/Card/ById/" + idCard;
			int costCard = restTemplate.getForObject(urlCardId, cardModel.class).getPrice();
			// envoyer nouvelle valeur argent
			costCard = - costCard;
			restTemplate.put(this.urlUserMoneyPut  + idUser, costCard);
			// collec -
				
		}
	
	public void sell(String idUser, String idCard) {
		// TODO appels aux services USER associ�s
		final String urlUserMoneyGetId = this.urlUserMoneyGet + idUser;
		int moneyUser = restTemplate.getForObject(urlUserMoneyGetId, int.class);
		
		final String urlCardId = "http://localhost:8083/Card/ById/" + idCard;
		int costCard = restTemplate.getForObject(urlCardId, cardModel.class).getPrice();

		restTemplate.put(this.urlUserMoneyPut  + idUser, costCard);
		//HttpEntity<int> delta = new HttpEntity<>(costCard);
		//restTemplate.exchange(this.urlUserMoneyPut  + idUser, HttpMethod.PUT, delta, Void.class);
		// collec -
		
	}
	public List<cardModel> list() {
		CardListWrapper cardListWrapper = restTemplate.getForObject(urlAllCards, CardListWrapper.class);
		return cardListWrapper.cardList;
	}

}
