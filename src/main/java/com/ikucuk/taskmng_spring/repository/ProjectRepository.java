package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {


}
