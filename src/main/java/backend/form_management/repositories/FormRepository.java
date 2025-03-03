package backend.form_management.repositories;

import backend.form_management.models.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FormRepository extends MongoRepository<Form, String> {
    List<Form> findAllByProjectId(String projectId);
}
