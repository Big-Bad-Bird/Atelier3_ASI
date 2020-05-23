package CardShop.gameService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GameService {
	
	public String Game(RoomModel room) {
		String winner = "error";
		
		//récupération de la première carte
		RestTemplate restTemplate = new RestTemplate();
		String URL= "http://localhost:8081/getCardByID/".concat(room.getIdCard1());
		CardModel card1 = restTemplate.getForObject(URL, CardModel.class);
		
		RestTemplate restTemplate2 = new RestTemplate();
		URL= "http://localhost:8081/getCardByID/".concat(room.getIdCard1());
		CardModel card2 = restTemplate2.getForObject(URL, CardModel.class);
		
		System.out.print(card1);
		int hp1 = card1.getHp();
		int hp2 = card2.getHp();
		
		while( hp1 > 0 || hp2 > 0 ) {
			hp1 = (int) (hp1 - (card2.getAttack()*( (1+Math.random())/2 ) - card1.getDefence()*( (1+Math.random())/2 )));
			hp2 = (int) (hp2 - (card1.getAttack()*( (1+Math.random())/2 ) - card2.getDefence()*( (1+Math.random())/2 )));
		}
		if (hp1 >= hp2) {
			winner = room.getIdUser1();
		}else {
			winner = room.getIdUser2();
		}
		return winner;
	}
	
}
