package com.ikucuk.taskmng_spring.dto;

import com.ikucuk.taskmng_spring.entity.Project;
import com.ikucuk.taskmng_spring.entity.Task;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String id;
    private String name;
    private String email;
    private List<Task> tasksOfEmployee;
    private List<Project> projectList;
}
