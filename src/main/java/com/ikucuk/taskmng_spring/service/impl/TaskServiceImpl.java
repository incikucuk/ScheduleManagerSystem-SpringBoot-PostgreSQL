package com.ikucuk.taskmng_spring.service.impl;

import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.entity.Task;
import com.ikucuk.taskmng_spring.mapper.TaskMapper;
import com.ikucuk.taskmng_spring.repository.TaskRepository;
import com.ikucuk.taskmng_spring.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskdto) {
        Task task = TaskMapper.mapToTasktEntity(taskdto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }
}
