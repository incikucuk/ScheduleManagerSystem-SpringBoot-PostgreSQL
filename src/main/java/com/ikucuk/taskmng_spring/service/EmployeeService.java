package com.ikucuk.taskmng_spring.service;

import com.ikucuk.taskmng_spring.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(String id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(String id,EmployeeDto employeeDto);

    void deleteEmployeeById(String id);

    EmployeeDto getAssignedProjectsToEmployee(String employeeId, String projectId);
}
