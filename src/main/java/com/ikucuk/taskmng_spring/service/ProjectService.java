package com.ikucuk.taskmng_spring.service;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.entity.Project;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);

    ProjectDto getProjectById(String projectId);

    List<ProjectDto> getAllProjects();

    ProjectDto updateProject(String projectId, ProjectDto projectDto);

    void deleteProject(String id);


    List<TaskDto> getTasksByProjectId(String id);

    TaskDto createTaskByProjectId(String id, TaskDto taskDto);

}
