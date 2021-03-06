package CardShop.roomService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RoomService {
	
	
	@Autowired
	private RoomRepository roomRepository;
	
	public RoomService() {

	}
	
	//test http
	public String helloGame(){
		RestTemplate restTemplate = new RestTemplate();
		String URL= "http://localhost:8085/hello";
		String result = restTemplate.getForObject(URL, String.class);
		
		System.out.print(result);
		return result;
	}
	
	// retourne toutes les cartes existantes
	public List<RoomModel> GetAllRooms() {
		List<RoomModel> rooms = new ArrayList<RoomModel>();
		for (RoomModel room : roomRepository.findAll()) {
	        rooms.add(room);
		}
		return rooms;
	}
	
	public RoomModel RoomByUserId(String id) {
		RoomModel result = new RoomModel();
		for (RoomModel room : roomRepository.findAll()) {
	        if (room.getIdUser1().equals(id) || room.getIdUser2().equals(id)) {
	            result = room;
	        }
		}
		return result;
	}
		
	// ajoute une room
	public String CreateRoom(String name, String idUser1, int mise) {
		RoomModel room = new RoomModel(name, idUser1, mise);
		roomRepository.save(room);
		return "room cree";
	}
	
	// ajoute une room
	public String AddCardRoom(String id, String idUser, String idCard) {
		String result = "fail";
		for (RoomModel room : roomRepository.findAll()) {
	        if (room.getId().equals(id)) {
	            if(room.getIdUser1().equals(idUser)){
	            	room.setIdCard1(idCard);
	            	roomRepository.save(room);
	            	result = "carte 1 ajoutee";
	            }else{
	            	room.setIdUser2(idUser);
	            	room.setIdCard2(idCard);
		            room.setRoomState("In Progress");
		            roomRepository.save(room);
		            GameRoom(room);
		            result = "carte 2 ajoutee";
	            }
	        }
		}
		return result;
	}
	
	//TODO Teste avec jeu réel (requête http marche)
	private void GameRoom(RoomModel room) {
		if (!(room.getIdCard1().equals("") || room.getIdCard2().equals(""))) {
			//Requête post pour le jeu
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<RoomModel> requestBody = new HttpEntity<>(room);
			String URL = "http://localhost:8085/initGame";
			
			//on reçoit l'id du vainqueur
			String winner = restTemplate.postForObject(URL, requestBody, String.class);
			room.setRoomState(winner);
			roomRepository.save(room);
			/*
			//On envoie la récompense
			RestTemplate restTemplate2 = new RestTemplate();
			URL= "http://localhost:8085/GiveReward/".concat(winner);
			String result = restTemplate2.getForObject(URL, String.class);
	        System.out.println(result);
	        */
		}
	}
	
	public String RoomGetResult(String id) {
		String result = "error";
		for (RoomModel room : roomRepository.findAll()) {
	        if (room.getId().equals(id)) {
	            result = room.getRoomState();
	        }
		}
		return result;
	}

}
