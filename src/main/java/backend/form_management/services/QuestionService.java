package backend.form_management.services;

import backend.form_management.models.Form;
import backend.form_management.models.Question;
import backend.form_management.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public Question createQuestion(String formId, Question question) {
            question.setFormId(formId); // quan hệ giữa Question và Form
        return questionRepository.save(question);
    }

    public Question updateQuestion( Question question) {

        return questionRepository.save(question);
    }


}
