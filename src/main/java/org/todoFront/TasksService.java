package org.todoFront;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.todoFront.entity.Task;
import org.todoFront.entity.User;

import java.util.Arrays;
import java.util.List;

@Service
public class TasksService {

    private final RestTemplate restTemplate;

    public TasksService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Task> getTasks(String userIdStr){

        ResponseEntity<Task[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/tasks/"+userIdStr,
                        Task[].class);

        Task[] tasks = response.getBody();
        return Arrays.asList(tasks.clone());
    }
}
