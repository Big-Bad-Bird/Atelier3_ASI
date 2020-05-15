package CardShop.marketService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import io.javabrains.springbootstarter.topic.Topic;


@Service
public class MarketService {

	
	// placeholder for error (not found)
	MarketModel errorMarket = new MarketModel();
	
	@Autowired
	private MarketRepository MarketRepository;
	List<MarketModel> market;
	public MarketService() {
		
		//TODO remplacer par appel à la BdD
		this.market = Arrays.asList(
				new MarketModel()
				);
	}


}	






