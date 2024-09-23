package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
