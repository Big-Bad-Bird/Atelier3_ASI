package CardShop.roomService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	
	// ajoute une room
		public void CreateRoom(String name, String idUser1, int mise) {
			RoomModel room = new RoomModel(name, idUser1, mise);
			roomRepository.save(room);
		}
	
	// ajoute une room
		public void AddCard(String id, String idUser, String idCard) {
			for (RoomModel room : rooms) {
		        if (room.getId().equals(id)) {
		            if(room.getIdUser1().equals(idUser)){
		            	room.setIdCard1(idCard);
		            }else if(room.getIdUser2().equals(idUser)){
		            	room.setIdCard2(idCard);
		            }
		            room.setRoomState("In Progress");
		            InitGame(room);
		        }
			}
		}
		
		private void InitGame(RoomModel room) {
			if (!(room.getIdCard1().equals("") || room.getIdCard2().equals(""))) {
				//TODO Envoyer requête au service Game
			}
		}
		
		public void RoomSetResult(String id, String idUser) {
			for (RoomModel room : rooms) {
		        if (room.getId().equals(id)) {
		            room.setRoomState(idUser);
		        }
			}
			//TODO Requête vers user pour récompense de victoire
		}
		
		public String RoomGetResult(String id) {
			String result = "error";
			for (RoomModel room : rooms) {
		        if (room.getId().equals(id)) {
		            result = room.getRoomState();
		        }
			}
			return result;
		}
	
}
