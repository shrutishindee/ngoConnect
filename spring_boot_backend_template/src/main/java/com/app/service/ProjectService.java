package com.app.service;

import java.util.List;

import com.app.dto.ProjectDTO;

public interface ProjectService {
    List<ProjectDTO> getProjects();
    ProjectDTO getProject(Long project_id);
    String addProject(ProjectDTO project);
    String updateProject(Long project_id, ProjectDTO project);
    String deleteProject(Long project_id);
}
