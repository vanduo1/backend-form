package backend.form_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "forms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    @Id
    private String id;

    private String title;
    private String description;
    private String projectId;
    private List<Question> questions;
}
