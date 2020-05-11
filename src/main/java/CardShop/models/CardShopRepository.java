package CardShop.models;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CardShopRepository extends CrudRepository<CardModel, String>{
	public Optional<CardModel> findById(String id);
	public List<CardModel> findAll(String id);
	public CardModel findOne(String name);
	public void add(CardModel card);
	public void remove(CardModel card);

}

