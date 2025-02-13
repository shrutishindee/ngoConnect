package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customExceptions.ResourceNotFoundException;
import com.app.dao.ProjectDao;
import com.app.dao.UserDao;  // Change AdminDao to UserDao
import com.app.dto.ProjectDTO;
import com.app.pojos.Project;
import com.app.pojos.User;  // Import User instead of Admin
import com.app.pojos.UserRole;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserDao userDao;  // Change AdminDao to UserDao

    @Autowired
    public ProjectServiceImpl(UserDao userDao) {  // Use UserDao here
        this.userDao = userDao;
    }

    @Override
    public List<ProjectDTO> getProjects() {
        List<Project> projects = projectDao.findAll();
        if (projects.isEmpty()) {
            System.out.println("No projects found");
        }
        return projects.stream().map(project -> {
            ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
            if (project.getAdmin() != null) {
                projectDTO.setAdminId(project.getAdmin().getId());
            }
            return projectDTO;
        }).collect(Collectors.toList());
    }


    @Override
    public ProjectDTO getProject(Long project_id) {
        Project project = projectDao.findById(project_id)
                .orElseThrow(() -> new ResourceNotFoundException("No such project found"));
        ProjectDTO projectDto = modelMapper.map(project, ProjectDTO.class);
        // Fetch the user (admin role) linked to the project
        if (project.getAdmin() != null) {
            projectDto.setAdminId(project.getAdmin().getId());
        }
        return projectDto;
    }

    @Override
    public String addProject(ProjectDTO project) {
        User user = userDao.findById(project.getAdminId())  // Fetch User instead of Admin
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + project.getAdminId()));
        
        // Check if the user has the role 'ADMIN' before assigning
        if (!user.getRole().equals(UserRole.ROLE_ADMIN)) {
            throw new ResourceNotFoundException("User is not an admin");
        }

        Project newProject = modelMapper.map(project, Project.class);
        newProject.setAdmin(user);  // Set the admin (user with admin role)
        projectDao.save(newProject);
        return "New Project added successfully";
    }

    @Override
    public String updateProject(Long project_id, ProjectDTO project) {
        if (projectDao.existsById(project_id)) {
            Project updatedProject = modelMapper.map(project, Project.class);
            
            User user = userDao.findById(project.getAdminId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + project.getAdminId()));
            
            // Ensure the user has the 'ADMIN' role
            if (!user.getRole().equals(UserRole.ROLE_ADMIN)) {
                throw new ResourceNotFoundException("User is not an admin");
            }

            updatedProject.setAdmin(user);  // Set the admin (user with admin role)
            projectDao.save(updatedProject);
            return "Project updated successfully";
        }
        throw new ResourceNotFoundException("Project doesn't exist");
    }

    @Override
    public String deleteProject(Long project_id) {
        if (projectDao.existsById(project_id)) {
            projectDao.deleteById(project_id);
            return "Project deleted successfully";
        }
        throw new ResourceNotFoundException("Project doesn't exist");
    }
}
