package com.ikucuk.taskmng_spring.service;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.entity.Project;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);

    ProjectDto getProjectById(Long projectId);

    List<ProjectDto> getAllProjects();

    ProjectDto updateProject(Long projectId, ProjectDto projectDto);

    void deleteProject(Long id);
}
