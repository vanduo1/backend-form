package backend.form_management.controllers;

import backend.form_management.models.Project;
import backend.form_management.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


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
}
