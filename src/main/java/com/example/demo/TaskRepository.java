package com.example.demo;

import io.reactivex.Flowable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository {

   Flowable<Task> getTasks();

}
