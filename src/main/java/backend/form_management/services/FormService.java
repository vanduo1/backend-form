package backend.form_management.services;

import backend.form_management.models.Form;
import backend.form_management.models.Option;
import backend.form_management.models.Project;
import backend.form_management.models.Question;
import backend.form_management.repositories.FormRepository;
import backend.form_management.repositories.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;
    @Autowired
    private OptionService optionService;
    @Autowired
    private QuestionService questionService;

//    //get all forms of a project
//    public List<Form> getAllFormsByProjectId(String projectId) {
//        return formRepository.findAllByProjectId(projectId);
//    }

    //get form by id
    public Optional<Form> getFormById(String formId) {
        return formRepository.findById(formId);
    }



    //create a form in the project
    public Form createForm(Form form) {
    List<Question> questions = form.getQuestions();
String formId = form.getId();
        for (Question question : questions) {
            Question question1 = questionService.createQuestion(formId, question);
            List<Option> options = question1.getOptions();
            for (Option option : options) {
                Option option1 = optionService.createOption(question1,option);
            }
        }
        return formRepository.save(form);
    }

    //update form
    public Form updateForm(String formId, Form form) {
        Optional<Form> existingForm = formRepository.findById(formId);

        if (existingForm.isPresent()) {
Form form1 = existingForm.get();
            List<Question> questions = form1.getQuestions();
            for (Question question : questions) {

                Question question1 = questionService.updateQuestion(question);
                List<Option> options = question1.getOptions();
                for (Option option : options) {
                    Option option1 = optionService.updateOption(option);
                }
            }
            return formRepository.save(form);
        } else {
            throw new RuntimeException("Form not found with ID: " + formId);
        }

    }



}
