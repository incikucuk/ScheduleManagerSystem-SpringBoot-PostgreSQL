package com.ikucuk.taskmng_spring.dto;

import com.ikucuk.taskmng_spring.enums.Status;
import lombok.*;

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
}
