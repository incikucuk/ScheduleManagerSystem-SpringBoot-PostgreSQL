package com.ikucuk.taskmng_spring.service;

import com.ikucuk.taskmng_spring.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);

    void deleteEmployeeById(Long id);
}
