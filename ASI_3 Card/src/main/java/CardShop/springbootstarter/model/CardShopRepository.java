package CardShop.springbootstarter.model;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CardShopRepository extends CrudRepository<CardModel, String>{
	public Optional<CardModel> findById(String id);
	public List<CardModel> findAll();

}

