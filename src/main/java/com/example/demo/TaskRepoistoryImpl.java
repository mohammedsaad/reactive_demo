package com.example.demo;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepoistoryImpl implements TaskRepository{
    @Override
    public Flowable<Task> getTasks() {
        return Flowable.create( (subscriber) -> {
            try{
                // risky operation
                List<Task> resultSet= new ArrayList<>();
                resultSet.add( new Task(1L, "Task1"));
                resultSet.add( new Task(2L, "Task2"));
                resultSet.add( new Task(3L, "Task3"));
                resultSet.add( new Task(4L, "Task4"));
                Thread.sleep(2000);

                resultSet.stream().forEach((item) -> {
                    subscriber.onNext(item);
                });

                subscriber.onComplete();
            } catch (Exception e) {
                subscriber.onError(e);
            }
            }, BackpressureStrategy.BUFFER);
    }
}