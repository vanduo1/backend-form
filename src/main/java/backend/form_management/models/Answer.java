package backend.form_management.models;

import org.springframework.data.annotation.Id;

public class Answer {
    @Id
    private String id;
    private String questionId;
    private String responseId;


}
