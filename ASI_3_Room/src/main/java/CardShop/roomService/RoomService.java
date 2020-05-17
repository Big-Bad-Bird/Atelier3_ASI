package CardShop.roomService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomService {
	
	
	@Autowired
	private RoomRepository roomRepository;
	List<RoomModel> rooms;
	public RoomService() {
		
		//TODO remplacer par appel à la BdD
		this.rooms = Arrays.asList(
				new RoomModel()
				);
	}
	
	// retourne toutes les cartes existantes
		public List<RoomModel> GetAllRooms() {
			List<RoomModel> rooms = new ArrayList<RoomModel>();
			for (RoomModel room : roomRepository.findAll()) {
		        rooms.add(room);
			}
			return rooms;
		}
		
	// ajoute une room
		public void CreateRoom(String name, String idUser1, int mise) {
			RoomModel room = new RoomModel(name, idUser1, mise);
			roomRepository.save(room);
		}
	
	// ajoute une room
		public void AddCardRoom(String id, String idUser, String idCard) {
			for (RoomModel room : roomRepository.findAll()) {
		        if (room.getId().equals(id)) {
		            if(room.getIdUser1().equals(idUser)){
		            	room.setIdCard1(idCard);
		            	roomRepository.save(room);
		            }else{
		            	room.setIdUser2(idUser);
		            	room.setIdCard2(idCard);
			            room.setRoomState("In Progress");
			            roomRepository.save(room);
			            InitGame(room);
		            }
		        }
			}
		}
		
		private void InitGame(RoomModel room) {
			if (!(room.getIdCard1().equals("") || room.getIdCard2().equals(""))) {
				//TODO Envoyer requête au service Game
			}
		}
		
		public void RoomSetResult(String id, String idUser) {
			for (RoomModel room : roomRepository.findAll()) {
		        if (room.getId().equals(id)) {
		            room.setRoomState(idUser);
		        }
			}
			//TODO Requête vers user pour récompense de victoire
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
