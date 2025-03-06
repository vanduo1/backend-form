package backend.form_management.controllers;

import backend.form_management.models.Form;
import backend.form_management.models.Project;
import backend.form_management.services.FormService;
import backend.form_management.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
 @Autowired
 private FormService formService;

    @GetMapping("")
    public ResponseEntity<List<Project> > getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Optional<Project>> getProjectDetails(@PathVariable("projectId") String projectId) {
        return new ResponseEntity<Optional<Project>>(projectService.getProjectById(projectId), HttpStatus.OK);
    }



    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }



    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable("projectId") String projectId) {
        projectService.deleteProject(projectId);
        List<Form> forms = formService.getAllFormsOfProject(projectId);
        for (Form form : forms) {
            formService.deleteForm(form.getId());
        }
        return ResponseEntity.ok("Project deleted successfully");
    }

}
