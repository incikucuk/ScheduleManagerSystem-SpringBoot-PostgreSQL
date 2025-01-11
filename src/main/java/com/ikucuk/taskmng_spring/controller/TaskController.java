package com.ikucuk.taskmng_spring.controller;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") String id, @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.updateTask(id,taskDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") String id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task Deleted sucessfully");
    }

    @PostMapping("{id}/complete")
    public ResponseEntity<String> isCompleted(@PathVariable("id") String id){
        taskService.isCompleted(id);
        return ResponseEntity.ok("Task Completed");

    }

}

