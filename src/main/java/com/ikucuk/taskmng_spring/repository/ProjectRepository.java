package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project,String> {


}
