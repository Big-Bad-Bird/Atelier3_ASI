package CardShop.userService;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CardModel {
	@Override
	public String toString() {
		return "CardModel [id=" + id + "]";
	}

	// Ajoute une clef primaire
	@Id
	private String id;
	private String name;
    private String description;
    private String family;
    private int hp;
    private int energy;
    private int defence;
    private int attack;
    private String imgUrl;
    private int price;
	
	public CardModel() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

