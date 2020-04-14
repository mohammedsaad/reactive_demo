package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }


    public List<Task> getAllTasks(){
       return service.getAllTasks();
    }


}
