package com.ikucuk.taskmng_spring.service.impl;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.entity.Project;
import com.ikucuk.taskmng_spring.entity.Task;
import com.ikucuk.taskmng_spring.exception.ResourceNotFoundException;
import com.ikucuk.taskmng_spring.mapper.ProjectMapper;
import com.ikucuk.taskmng_spring.mapper.TaskMapper;
import com.ikucuk.taskmng_spring.repository.ProjectRepository;
import com.ikucuk.taskmng_spring.repository.TaskRepository;
import com.ikucuk.taskmng_spring.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    TaskRepository taskRepository;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {

        Project project = ProjectMapper.mapToProjectEntity(projectDto);
        Project savedProject =  projectRepository.save(project);
        return ProjectMapper.mapToProjectDto(savedProject);
    }

    @Override
    public ProjectDto getProjectById(String projectId) {
      Project project =  projectRepository.findById(projectId).orElseThrow(() ->
              new RuntimeException("Project not found with given id: " + projectId));
       return ProjectMapper.mapToProjectDto(project);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> getAllProjects = projectRepository.findAll();

        return getAllProjects.stream().map(
                (project) -> ProjectMapper.mapToProjectDto(project)).collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProject(String projectId, ProjectDto projectDto) {
       Project project =  projectRepository.findById(projectId).
               orElseThrow(() -> new ResourceNotFoundException("Project Not Found with Project id: " +projectId));

                project.setName(projectDto.getName());
                project.setDescription(projectDto.getDescription());
                project.setStartDate(projectDto.getStartDate());
                project.setEndDate(projectDto.getEndDate());
                project.setStatus(projectDto.getStatus());

                Project updatedProject = projectRepository.save(project);

        return ProjectMapper.mapToProjectDto(updatedProject);
    }

    @Override
    public void deleteProject(String id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found" + id));
        projectRepository.deleteById(id);
    }

    @Override
    public List<TaskDto> getTasksByProjectId(String id) {
        Project project = projectRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Project not found with given id: " + id));
        List<Task> taskList = project.getTasks();
        return taskList.stream().map(
                (task) -> TaskMapper.mapToTaskDto(task)).collect(Collectors.toList());

    }

    @Override
    public TaskDto createTaskByProjectId(String id, TaskDto taskDto) {
        Project project = projectRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Project not found with given id: " + id));
        Task task = TaskMapper.mapToTasktEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }
}
