package com.ikucuk.taskmng_spring.controller;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

}
