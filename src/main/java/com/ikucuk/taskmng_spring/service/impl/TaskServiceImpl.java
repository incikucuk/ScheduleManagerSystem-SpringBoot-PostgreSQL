package com.ikucuk.taskmng_spring.service.impl;

import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.entity.Project;
import com.ikucuk.taskmng_spring.entity.Task;
import com.ikucuk.taskmng_spring.enums.Status;
import com.ikucuk.taskmng_spring.mapper.TaskMapper;
import com.ikucuk.taskmng_spring.repository.ProjectRepository;
import com.ikucuk.taskmng_spring.repository.TaskRepository;
import com.ikucuk.taskmng_spring.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;
    ProjectRepository projectRepository;

    @Override
    public TaskDto createTask(TaskDto taskdto) {
        Task task = TaskMapper.mapToTasktEntity(taskdto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found with given id: " + id));
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setStatus(taskDto.getStatus());
        task.setProjectId(taskDto.getProjectId());
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found with given id: " + id));
        taskRepository.delete(task);
    }

    @Override
    public void isCompleted(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found with given id: " + id));

        if(task.getStatus() != Status.COMPLETED){
            task.setStatus(Status.COMPLETED);
            taskRepository.save(task);
            System.out.println(task.toString());
        }
    }
}
