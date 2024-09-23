package com.ikucuk.taskmng_spring.mapper;

import com.ikucuk.taskmng_spring.dto.EmployeeDto;
import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.entity.Employee;
import com.ikucuk.taskmng_spring.entity.Task;

public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task){

        return new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getAssignedTo(),
                task.getStatus(),
                task.getProjectId()
        );
    }

    public static Task mapToTasktEntity(TaskDto taskDto){
        return new Task(
                taskDto.getId(),
                taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getAssignedTo(),
                taskDto.getStatus(),
                taskDto.getProjectId()
        );
    }
}
