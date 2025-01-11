package com.ikucuk.taskmng_spring.entity;

import com.ikucuk.taskmng_spring.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "tasks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "assignedTo")
    private String assignedTo;

    @Column(name = "status")
    private Status status;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "employee_id")
    private Integer employeeId;

}
