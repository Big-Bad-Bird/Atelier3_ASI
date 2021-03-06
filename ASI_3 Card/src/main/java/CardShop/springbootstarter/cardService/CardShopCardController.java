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
	
	// Pour debug si prb 404
	@RequestMapping("/Card/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/Card/init")
	public void init() {
		cardShopCardService.initCards();
	}
	@RequestMapping("/Card/getAllCards")
	public List<CardModel> getAllCards() {
		return cardShopCardService.getallCard();
	}
	
	@RequestMapping("/Card/getAllCardsWrapper")
	public CardListWrapper getAllCardsWrapper() {
		CardListWrapper cardListWrapper = new CardListWrapper();
		cardListWrapper.cardList = this.getAllCards();
		return cardListWrapper;
	}
	
	@RequestMapping("/Card/ById/{id}") // syntaxe pour ça: /Byid/id
	public CardModel getCardById(@PathVariable String id) {
		return cardShopCardService.getCardById(id);
	}
	
	@RequestMapping("/Card/ByName/{name}") // syntaxe pour ça: /ByName/name
	public CardModel getCard(@PathVariable String name) {
		return cardShopCardService.getCard(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/Card/addCard")
	public void addCard(@RequestBody CardModel card) {
		cardShopCardService.addCard(card);
	}
	
//	
//	@RequestMapping(method=RequestMethod.DELETE,value="/delCard/{card}")
//	public void delCard(@PathVariable CardModel card) {
//		cardShopCardService.delCard(card);
//	}
//	
//	@RequestMapping(method=RequestMethod.PUT,value="/transaction")
//	public void buyCard(@RequestBody Transactor transactor) { 
//		cardShopCardService.transactionCard(transactor);
//	}

}


