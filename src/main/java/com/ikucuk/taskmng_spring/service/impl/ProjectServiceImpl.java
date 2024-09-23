package com.ikucuk.taskmng_spring.service.impl;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.entity.Project;
import com.ikucuk.taskmng_spring.exception.ResourceNotFoundException;
import com.ikucuk.taskmng_spring.mapper.ProjectMapper;
import com.ikucuk.taskmng_spring.repository.ProjectRepository;
import com.ikucuk.taskmng_spring.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {

        Project project = ProjectMapper.mapToProjectEntity(projectDto);
        Project savedProject =  projectRepository.save(project);
        return ProjectMapper.mapToProjectDto(savedProject);
    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
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
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
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
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found" + id));
        projectRepository.deleteById(id);
    }

}
