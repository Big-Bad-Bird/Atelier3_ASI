package Market.springbootstarter.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class marketService {

	@Autowired
	private marketRepository market;
	public marketService() {
		// TODO Auto-generated constructor stub
	}

}
