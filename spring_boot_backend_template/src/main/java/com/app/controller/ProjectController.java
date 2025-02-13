package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProjectDTO;
import com.app.pojos.Project;
import com.app.service.ProjectService;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:3000")	
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;
    
    @GetMapping
    public ResponseEntity<?> getAllProjects(){
        List<ProjectDTO> projects = projectService.getProjects();
        if(projects.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(projects);
    }
    
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProject(@PathVariable Long project_id){
    	ProjectDTO projectdto = projectService.getProject(project_id);
        return ResponseEntity.ok(projectdto);
    }
    
    @PostMapping
    public ResponseEntity<?> addNewProject(@RequestBody ProjectDTO project){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addProject(project));
    }
    
    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProject(@RequestBody ProjectDTO project, @PathVariable Long project_id){
        return ResponseEntity.ok(projectService.updateProject(project_id, project));
    }
    
    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable Long project_id){
        return ResponseEntity.ok(projectService.deleteProject(project_id));
    }
}
