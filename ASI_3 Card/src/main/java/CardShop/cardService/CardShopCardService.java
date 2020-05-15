package CardShop.cardService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import io.javabrains.springbootstarter.topic.Topic;


@Service
public class CardShopCardService {

	
	// placeholder for error (card not found)
	CardModel errorCard = new CardModel();
	
	@Autowired
	private CardShopRepository CardShopRepository;
	List<CardModel> cards;
	public CardShopCardService() {
		
		//TODO remplacer par appel à la BdD
		this.cards = Arrays.asList(
				new CardModel(),
				new CardModel(),
				new CardModel(),
				new CardModel(),
				new CardModel(),
				new CardModel()
				);
		CardShopRepository.saveAll(this.cards);
	}

	// retourne toutes les cartes existantes
	public List<CardModel> getallCard() {
		List<CardModel> cards = new ArrayList<CardModel>();
		
		for (CardModel card : CardShopRepository.findAll()) {
	        cards.add(card);
		}
		return cards;
	}

	// retourne une carte spécifique
	public CardModel getCard(String name) {
		CardModel cardReturn = this.errorCard;
		
		List<CardModel> cardList = new ArrayList<CardModel>();
		
		for (CardModel card : CardShopRepository.findAll()) {
	        cardList.add(card);
		}
		
		for (CardModel card : cardList) {
	        if (card.getName().equals(name)) {
	            cardReturn = card; 
	        }
		}
		return cardReturn;
	        
	}	
	
	// ajoute une carte à la liste des cartes
	public void addCard(CardModel card) {
		CardShopRepository.save(card);
	}
	
	// supprime une carte de la liste des cartes
	public void delCard(CardModel card) {
		CardShopRepository.deleteById(card.getId());
	}
	
	
	// renvoie une carte par son Id unique
	public CardModel getCardById(String id) {
		CardModel cardReturn = this.errorCard;
		Optional<CardModel> searchAns = CardShopRepository.findById(String.valueOf(id));
		if (searchAns.isPresent()) {
			cardReturn = searchAns.get();
		};
		return cardReturn;
	}


	

	public boolean transactionCard(Transactor transactor) {// , User acheteur une fois qu'on aura un type user
		boolean answer = false;
	
		User cardBuyer = transactor.cardBuyer;
		User cardSeller = transactor.cardSeller;
		if (cardBuyer.getArgent() >= transactor.cost) {
			cardBuyer.setArgent(cardBuyer.getArgent() - transactor.cost);
			cardSeller.setArgent(cardSeller.getArgent() + transactor.cost);
			
			/*
			*int idAcheteur = cardBuyer.getId();
			*int idVendeur = cardSeller.getId();
			*String cardId = transactor.cardId;
			*/
			
			// à ce stade on peut trouver les utilisateurs par Id dans la BdD
			// TODO ajouter connexion BdD quand on pourra
		}
		return answer;
	}

}	






