package CardShop.springbootstarter.cardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class CardShopCardController {
	
	@Autowired
	private CardShopCardService cardShopCardService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/Card/getAllCards")
	public List<CardModel> getAllCards() {
		return cardShopCardService.getallCard();
	}
		
	@RequestMapping("/ById/{id}") // syntaxe pour ça: /Byid/id
	public CardModel getCardById(@PathVariable String id) {
		return cardShopCardService.getCardById(id);
	}
	
	@RequestMapping("/ByName/{name}") // syntaxe pour ça: /ByName/name
	public CardModel getCard(@PathVariable String name) {
		return cardShopCardService.getCard(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addCard")
	public void addCard(@RequestBody CardModel card) {
		cardShopCardService.addCard(card);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delCard/{card}")
	public void delCard(@PathVariable CardModel card) {
		cardShopCardService.delCard(card);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/transaction")
	public void buyCard(@RequestBody Transactor transactor) { 
		cardShopCardService.transactionCard(transactor);
	}

}


