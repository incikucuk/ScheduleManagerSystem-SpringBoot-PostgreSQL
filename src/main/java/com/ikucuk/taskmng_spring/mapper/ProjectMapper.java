package com.ikucuk.taskmng_spring.mapper;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.entity.Project;

public class ProjectMapper {

    public static ProjectDto mapToProjectDto(Project project){
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getStatus(),
                project.getTasks(),
                project.getEmployeeList()
        );
    }

    public static Project mapToProjectEntity(ProjectDto projectDto){
        return new Project(
                projectDto.getId(),
                projectDto.getName(),
                projectDto.getDescription(),
                projectDto.getStartDate(),
                projectDto.getEndDate(),
                projectDto.getStatus(),
                projectDto.getTasks(),
                projectDto.getEmployeeList()
        );
    }
}
