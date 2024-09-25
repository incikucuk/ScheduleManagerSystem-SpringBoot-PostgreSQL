package com.ikucuk.taskmng_spring.dto;

import com.ikucuk.taskmng_spring.entity.Employee;
import com.ikucuk.taskmng_spring.entity.Task;
import com.ikucuk.taskmng_spring.enums.Status;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Status status;

    private List<Task> tasks;

    private List<Employee> employeeList;

}
