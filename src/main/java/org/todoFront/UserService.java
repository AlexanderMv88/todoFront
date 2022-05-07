package org.todoFront;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.todoFront.entity.User;


@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User checkAndGetUser(String userName){
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity("http://localhost:8080/check/user", new User(userName), User.class);
        return userResponseEntity.getBody();
    }
}
