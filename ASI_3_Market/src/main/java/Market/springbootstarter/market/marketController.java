package Market.springbootstarter.market;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin
@RestController
public class marketController {
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private marketService market;
	
	// Pour debug si prb 404
	@RequestMapping("/market/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/market/sell")
	public void Buy(@RequestBody String transaction) {
		marketModel modelM = new marketModel();
		try {
			modelM = objectMapper.readValue(transaction, marketModel.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		market.buy(modelM.idUser, modelM.idCard);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/market/buy")
	public void Sell(@RequestBody String transaction) {
		marketModel modelM = new marketModel();
		try {
			modelM = objectMapper.readValue(transaction, marketModel.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		market.sell(modelM.idUser, modelM.idCard);
	}
	
	@RequestMapping("/market/list")
	public List<cardModel> list() {
		return market.list();
	}
}
