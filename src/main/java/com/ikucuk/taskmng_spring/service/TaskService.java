package com.ikucuk.taskmng_spring.service;

import com.ikucuk.taskmng_spring.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskdto);

    TaskDto updateTask(String id, TaskDto taskDto);

    void deleteTask(String id);

    void isCompleted(String id);

}
