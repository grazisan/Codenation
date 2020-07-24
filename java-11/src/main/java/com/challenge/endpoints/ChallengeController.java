package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeServiceInterface;

    public ChallengeController(ChallengeServiceInterface challengeServiceInterface) {
        this.challengeServiceInterface = challengeServiceInterface;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam Long accelerationId,
                                                         @RequestParam Long userId){
        return this.challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
