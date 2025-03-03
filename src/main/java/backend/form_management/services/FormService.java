package backend.form_management.services;

import backend.form_management.models.Form;
import backend.form_management.models.Option;
import backend.form_management.models.Question;
import backend.form_management.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;


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
        return formRepository.save(form);
    }

    //update form
    public Form updateForm(String formId, Form form) {
        Optional<Form> existingForm = formRepository.findById(formId);
        if (existingForm.isPresent()) {
              return formRepository.save(form);             //save to collection if existed
        } else {
            throw new RuntimeException("Form not found with ID: " + formId);
        }
    }

    //delete



}
