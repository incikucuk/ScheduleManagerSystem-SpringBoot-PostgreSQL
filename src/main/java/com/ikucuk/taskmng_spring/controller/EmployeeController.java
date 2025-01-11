package com.ikucuk.taskmng_spring.controller;

import com.ikucuk.taskmng_spring.dto.EmployeeDto;
import com.ikucuk.taskmng_spring.entity.Employee;
import com.ikucuk.taskmng_spring.mapper.EmployeeMapper;
import com.ikucuk.taskmng_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    //@ManyToMany relation durumunu incelemek icin ek olarak yazdim
    @PostMapping("/{id}/projects")
    public ResponseEntity<EmployeeDto> assignedProjectToEmployee(
            @PathVariable("id") String id,
            @PathVariable("projectId") String projectId
    ){
       EmployeeDto updatedEmployee =  employeeService.getAssignedProjectsToEmployee(id,projectId);
        return new ResponseEntity<EmployeeDto>(updatedEmployee,HttpStatus.OK);
    }





}
