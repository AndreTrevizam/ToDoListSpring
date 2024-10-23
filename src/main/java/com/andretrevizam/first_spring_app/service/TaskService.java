package com.andretrevizam.first_spring_app.service;

import com.andretrevizam.first_spring_app.domain.Task;
import com.andretrevizam.first_spring_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.Hibernate.map;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
        .map(task -> {
            task.setName(updatedTask.getName());
            task.setCompleted(true);
            task.setDescription(updatedTask.getDescription());
            return taskRepository.save(task);
        })
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }
}
