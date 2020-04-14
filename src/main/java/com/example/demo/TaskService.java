package com.example.demo;

import io.reactivex.Flowable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Flowable<Task> getAllTasks(){
      return  taskRepository
              .getTasks()
              .map(task -> { return new Task(task.getId(), task.getName().toUpperCase()); });
    }
}
