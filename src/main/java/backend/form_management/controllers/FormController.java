package backend.form_management.controllers;

import backend.form_management.models.Form;
import backend.form_management.models.Project;
import backend.form_management.repositories.FormRepository;
import backend.form_management.services.FormService;
import backend.form_management.services.ProjectService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class FormController {
    @Autowired
    private FormService formService ;

    @Autowired
    private ProjectService projectService ;

//    @GetMapping("")
//    public ResponseEntity<List<Form>> getAllFormOfProject(@PathVariable("projectId")String projectId) {
//        return new ResponseEntity<>(formService.getAllFormsByProjectId(projectId), HttpStatus.OK);
//    }

    @GetMapping("/forms/{formId}")
    public ResponseEntity<Optional<Form>> getFormDetails(@PathVariable("formId") String formId) {
        return new ResponseEntity<Optional<Form>>(formService.getFormById(formId), HttpStatus.OK);
    }

    @PostMapping("/{projectId}/form-create")
    public Form createFormForProject( @PathVariable("projectId") String projectId, @RequestBody Form form) {
        form.setProjectId(projectId);
        Form createdForm = formService.createForm(form);
        projectService.addFormToProject(projectId, createdForm);
        return createdForm;
    }

    @PutMapping("/{projectId}/forms/{formId}/update")
    public ResponseEntity<Form> getFormDetails(@PathVariable("projectId") String projectId, @PathVariable("formId") String formId, @RequestBody Form form) {
        try {
            Form updatedForm   = formService.updateForm(formId, form);
            projectService.updateFormToProject(projectId, formId,updatedForm);
            return ResponseEntity.ok(updatedForm);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
