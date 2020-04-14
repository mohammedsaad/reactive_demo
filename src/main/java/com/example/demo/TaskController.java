package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }


    @GetMapping("/tasks")
    public DeferredResult<List<Task>> getAllTasks(){
       DeferredResult<List<Task>>  result = new DeferredResult<>();
       service.getAllTasks()
               .toList()
               .subscribe((list) -> {
                   result.setResult(list);
                   }, (ex) -> {
           result.setErrorResult(ResponseEntity.badRequest().build());
       });
       return result;
    }

}
