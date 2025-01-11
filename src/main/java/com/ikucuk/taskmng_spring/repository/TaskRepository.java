package com.ikucuk.taskmng_spring.repository;

import com.ikucuk.taskmng_spring.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {

}
