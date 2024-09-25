package com.ikucuk.taskmng_spring.service;

import com.ikucuk.taskmng_spring.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskdto);

    TaskDto updateTask(Long id, TaskDto taskDto);

    void deleteTask(Long id);

    void isCompleted(Long id);

}
