package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam Long challengeId,
                                                                  @RequestParam Long accelerationId){
        return submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }


}
