package CardShop.gameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class GameController {
	@Autowired
	private GameService gameService;
	
	// Pour debug si prb 404
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	// Pour debug requête http
	@RequestMapping(method=RequestMethod.POST,value="/testRoom")
		public String testRoom(@RequestBody RoomModel room) {
			return room.getIdUser1();
		}
	
	@RequestMapping(method=RequestMethod.POST,value="/initGame")
	public String Game(@RequestBody RoomModel room) {
		return gameService.Game(room);
	}
}


