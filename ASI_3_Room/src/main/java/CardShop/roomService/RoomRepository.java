package CardShop.roomService;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomModel, String> {
	public Optional<RoomModel> findById(String id);
	public List<RoomModel> findAll();
}
