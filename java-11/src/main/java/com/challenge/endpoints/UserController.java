package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long userId){
        return new ResponseEntity<User>(this.userServiceInterface.findById(userId)
        .orElseThrow(() -> new RuntimeException()),HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(@RequestParam (required = false) String accelerationName,
                                                        @RequestParam (required = false) Long companyId){
        List<User> users = new ArrayList<>();

        if (accelerationName != null){
            users.addAll(this.userServiceInterface.findByAccelerationName(accelerationName));
        }
        if(companyId != null){
            users.addAll(this.userServiceInterface.findByCompanyId(companyId));
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
