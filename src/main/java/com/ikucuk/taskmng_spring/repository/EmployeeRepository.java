package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
