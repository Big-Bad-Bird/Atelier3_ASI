package CardShop.roomService;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class RoomModel {
	// Ajoute une clef primaire
	@Id
	private String id;

	private String name;
	private int mise;
	private String idUser1;
	private String idUser2;
	private String idCard1;
	private String idCard2;
	

	public RoomModel(String name, String idUser1, String idCard1) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.idUser1 = idUser1;
		this.idCard1 = idCard1;
		this.idUser2 = "";
		this.idCard2 = "";
	}
	
	public RoomModel() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMise() {
		return mise;
	}


	public void setMise(int mise) {
		this.mise = mise;
	}


	public String getIdUser1() {
		return idUser1;
	}


	public void setIdUser1(String idUser1) {
		this.idUser1 = idUser1;
	}


	public String getIdUser2() {
		return idUser2;
	}


	public void setIdUser2(String idUser2) {
		this.idUser2 = idUser2;
	}


	public String getIdCard1() {
		return idCard1;
	}


	public void setIdCard1(String idCard1) {
		this.idCard1 = idCard1;
	}


	public String getIdCard2() {
		return idCard2;
	}


	public void setIdCard2(String idCard2) {
		this.idCard2 = idCard2;
	}

	

}

