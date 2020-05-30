package CardShop.marketService;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MarketModel {
	// Ajoute une clef primaire
	@Id
	private String idMarket;
	
	private String idCard;
	private String idUser;
	private String price;

	public MarketModel(String idCard, String idUser) {
		super();
		this.idMarket = UUID.randomUUID().toString();
		this.idCard = idCard;
		this.idUser = idUser;
		
		// Besoin d'aller récupérer prix sur service Card
	}
	
	public MarketModel() {
		super();
		this.idMarket = UUID.randomUUID().toString();
		this.idCard = "error";
		this.idUser = "error";
		
		// Besoin d'aller récupérer prix sur service Card
	}

	public String getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(String idMarket) {
		this.idMarket = idMarket;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
}

