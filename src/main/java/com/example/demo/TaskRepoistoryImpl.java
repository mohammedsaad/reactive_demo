package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TaskRepoistoryImpl implements TaskRepository{
    @Override
    public List<Task> getTasks() {
        {
            List<Task> tasks= new ArrayList<>();
            tasks.add( new Task(1L, "Task1"));
            tasks.add( new Task(2L, "Task2"));
            tasks.add( new Task(3L, "Task3"));
            tasks.add( new Task(4L, "Task4"));

            return tasks;
        }
    }
}
