package backend.form_management.services;

import backend.form_management.models.Form;
import backend.form_management.models.Project;
import backend.form_management.repositories.ProjectRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    //get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    //get project by id
    public Optional<Project> getProjectById(String projectId) {
        return projectRepository.findById(String.valueOf(projectId));
    }


    //creat a new project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }




    //add form to project
    public void addFormToProject(String projectId, Form form) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.getForms().add(form);
            projectRepository.save(project);
        }
    }

    //update form of project
    public void updateFormToProject(String projectId, String formId, Form updatedForm) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.getForms().removeIf(form -> form.getId().equals(formId));    //delete old form
            project.getForms().add(updatedForm);        //add new form
            projectRepository.save(project);
        }
    }

    //delete form of project
    public void deleteFormOfProject(String projectId, String formId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.getForms().removeIf(form -> form.getId().equals(formId));
            projectRepository.save(project);
        }
    }

    //delete project
    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }



}
