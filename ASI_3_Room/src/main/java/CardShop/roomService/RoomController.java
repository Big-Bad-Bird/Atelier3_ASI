package CardShop.roomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	// Pour debug si prb 404
	@RequestMapping("/hello")
	public String hello() {
		return roomService.helloGame();
	}
	
	@RequestMapping("/GetAllRooms")
	public List<RoomModel> GetAllRooms() {
		return roomService.GetAllRooms();
	}
	
		@RequestMapping("/RoomByUserId/{id}")
	public RoomModel RoomByUserId(@PathVariable String id) {
		return roomService.RoomByUserId(id);
	}
		
	@RequestMapping("/CreateRoom/{name}/{idUser1}/{mise}")
	public void CreateRoom(@PathVariable String name, @PathVariable String idUser1, @PathVariable int mise) {
		roomService.CreateRoom(name, idUser1, mise);
	}
	
	@RequestMapping("/AddCardRoom/{id}/{idUser}/{idCard}")
	public void AddCard(@PathVariable String id, @PathVariable String idUser, @PathVariable String idCard) {
		roomService.AddCardRoom(id, idUser, idCard);
	}
	
	@RequestMapping("/RoomGetResult/{id}")
	public String RoomGetResult(@PathVariable String id) {
		return roomService.RoomGetResult(id);
	}
}

