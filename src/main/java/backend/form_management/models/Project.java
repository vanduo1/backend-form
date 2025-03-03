package backend.form_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private String  id;
    private String name;
    private String description;
    private List<Form> forms;

}
