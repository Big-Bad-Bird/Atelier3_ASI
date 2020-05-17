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
	@RequestMapping("/Card/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/getAllRooms")
	public List<RoomModel> getAllRooms() {
		return roomService.getallRooms();
	}
	
	@RequestMapping("/CreateRoom/{name}/{idUser1}/{mise}")
	public void CreateRoom(@PathVariable String name, @PathVariable String idUser1, @PathVariable int mise) {
		roomService.CreateRoom(name, idUser1, mise);
	}
	
	@RequestMapping("/AddCardRoom/{id}/{idUser}/{idCard}")
	public void AddCard(@PathVariable String id, @PathVariable String idUser, @PathVariable String idCard) {
		roomService.AddCardRoom(id, idUser, idCard);
	}

	@RequestMapping("/RoomSetResult/{id}/{idUser}")
	public void RoomSetResult(@PathVariable String id, @PathVariable String idUser) {
		roomService.RoomSetResult(id, idUser);
	}
	
	@RequestMapping("/RoomGetResult/{id}")
	public String RoomGetResult(@PathVariable String id) {
		return roomService.RoomGetResult(id);
	}
	
}


