package com.ikucuk.taskmng_spring.controller;

import com.ikucuk.taskmng_spring.dto.ProjectDto;
import com.ikucuk.taskmng_spring.dto.TaskDto;
import com.ikucuk.taskmng_spring.service.ProjectService;
import com.ikucuk.taskmng_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable("id") Long projectId){
        return new ResponseEntity<>(projectService.getProjectById(projectId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto projectDto){
       ProjectDto updatedProject =  projectService.updateProject(id,projectDto);
        return new ResponseEntity<>(updatedProject,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project Deleted Sucessfully!");
    }

    //projenin gorevlerini listele
    @GetMapping("{id}/tasks")
    public ResponseEntity<List<TaskDto>> getTasksProject(@PathVariable("id") Long id){
        return new ResponseEntity<>(projectService.getTasksByProjectId(id), HttpStatus.OK);
    }


    //belirli bir projeye yeni görev ekle
    @PostMapping("{id}/tasks")
    public ResponseEntity<TaskDto> createTaskWitByProjectId(@PathVariable Long id,@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(projectService.createTaskByProjectId(id,taskDto), HttpStatus.CREATED);
    }



}
