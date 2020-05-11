package CardShop.cardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardShopCardController {
	@Autowired
	private CardShopCardService cardShopService;
	
	@RequestMapping("/Card/getAllCards")
	public List<CardModel> getAllCards() {
		return cardShopService.getallCard();
	}
	
	@RequestMapping("/ById/{id}") // syntaxe pour ça: /ById/id="string"
	public CardModel getCardById(@PathVariable String id) {
		return cardShopService.getCardById(id);
	}
	
	@RequestMapping("/ByName/{name}") // syntaxe pour ça: /ByName/name="string"
	public CardModel getCard(@PathVariable String name) {
		return cardShopService.getCard(name);
	}
	
	@RequestMapping("/addCard/{card}")
	public void addCard(@PathVariable CardModel card) {
		cardShopService.addCard(card);
	}
	
	@RequestMapping("/delCard/{card}")
	public void delCArd(@PathVariable CardModel card) {
		cardShopService.delCard(card);
	}
}


