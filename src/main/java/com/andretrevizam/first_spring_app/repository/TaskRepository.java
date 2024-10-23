package com.andretrevizam.first_spring_app.repository;

import com.andretrevizam.first_spring_app.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
