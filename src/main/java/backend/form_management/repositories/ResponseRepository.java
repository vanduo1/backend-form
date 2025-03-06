package backend.form_management.repositories;

import backend.form_management.models.Response;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResponseRepository extends MongoRepository<Response, String> {
    List<Response> getAllByFormId(String formId);
}
