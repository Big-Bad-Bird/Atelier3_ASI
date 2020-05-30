package Market.springbootstarter.market;

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
	
	@RequestMapping(method=RequestMethod.POST,value="/market/addBuy")
	public void addBuy(@RequestBody marketModel transaction) {
		market.addBuy(transaction);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/market/addSell")
	public void addSell(@RequestBody marketModel transaction) {
		market.addSell(transaction);
	}
}
