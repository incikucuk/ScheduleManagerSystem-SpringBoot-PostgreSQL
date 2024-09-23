package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {


}
