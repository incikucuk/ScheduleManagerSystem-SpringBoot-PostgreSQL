package com.ikucuk.taskmng_spring.service.impl;

import com.ikucuk.taskmng_spring.dto.EmployeeDto;
import com.ikucuk.taskmng_spring.entity.Employee;
import com.ikucuk.taskmng_spring.entity.Project;
import com.ikucuk.taskmng_spring.exception.ResourceNotFoundException;
import com.ikucuk.taskmng_spring.mapper.EmployeeMapper;
import com.ikucuk.taskmng_spring.repository.EmployeeRepository;
import com.ikucuk.taskmng_spring.repository.ProjectRepository;
import com.ikucuk.taskmng_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    ProjectRepository projectRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployeetEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Employee not found with given id: "+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) ->
                EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with given id: "+id));
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with given id: "+id));
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto getAssignedProjectsToEmployee(Long employeeId, Long projectId) {
        List<Project> projectList = null;
        Project project = projectRepository.findById(projectId).orElseThrow(() ->
                new ResourceNotFoundException("projectId not found with given id: "+ projectId));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("employeeId not found with given id: "+employeeId));

        projectList.add(project);
        employee.setProjectList(projectList);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


}
