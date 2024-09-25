package com.ikucuk.taskmng_spring.dto;

import com.ikucuk.taskmng_spring.entity.Task;
import com.ikucuk.taskmng_spring.enums.Status;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;
    private String name;
    private String description;
    private String assignedTo;
    private Status status;
    private Integer projectId;
    private Integer employeeId;
}
