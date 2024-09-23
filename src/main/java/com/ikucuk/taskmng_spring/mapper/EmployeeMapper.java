package com.ikucuk.taskmng_spring.mapper;

import com.ikucuk.taskmng_spring.dto.EmployeeDto;
import com.ikucuk.taskmng_spring.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployeetEntity(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail()
        );
    }
}
