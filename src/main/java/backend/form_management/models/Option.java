package backend.form_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "options")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    @Id
    private String id;

    private String questionId;
    private String optionContent;
    private boolean isChecked ;

}
