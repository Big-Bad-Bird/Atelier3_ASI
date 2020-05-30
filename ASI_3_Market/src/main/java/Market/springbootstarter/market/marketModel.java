package Market.springbootstarter.market;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class marketModel {

		@Id
		public String id;
		
		public int prix;
}
