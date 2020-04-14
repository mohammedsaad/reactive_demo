package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {
   List<Task> getTasks();
}
