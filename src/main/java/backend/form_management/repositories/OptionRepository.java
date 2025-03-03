package backend.form_management.repositories;

import backend.form_management.models.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OptionRepository extends MongoRepository<Option, String> {

}
