package backend.form_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private String responseId;
    private String questionId; // Liên kết với Question
    private String answerText; // Nếu là câu hỏi dạng text
    private List<String> selectedOptions; // Nếu là dạng checkbox hoặc radio

}