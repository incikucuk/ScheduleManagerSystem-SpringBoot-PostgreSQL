package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
