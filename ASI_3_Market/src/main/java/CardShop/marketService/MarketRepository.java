package CardShop.marketService;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MarketRepository extends CrudRepository<MarketModel, String>{
	public Optional<MarketModel> findById(String id);
	public List<MarketModel> findAll();

}
