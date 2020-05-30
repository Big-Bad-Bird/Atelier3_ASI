package Market.springbootstarter.market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class marketController {
	
	@Autowired
	private marketService market;
	
	// Pour debug si prb 404
	@RequestMapping("/market/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/market/sell")
	public void Buy(@RequestBody marketModel transaction) {
		market.buy(transaction.idUser, transaction.idCard);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/market/buy")
	public void Sell(@RequestBody marketModel transaction) {
		market.sell(transaction.idUser, transaction.idCard);
	}
	
	@RequestMapping("/market/list")
	public List<cardModel> list() {
		return market.list();
	}
}
