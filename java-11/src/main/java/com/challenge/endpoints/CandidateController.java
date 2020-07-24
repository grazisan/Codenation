package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateServiceInterface;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    public CandidateController(CandidateServiceInterface candidateServiceInterface) {
        this.candidateServiceInterface = candidateServiceInterface;
    }

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity <CandidateDTO> findById(@PathVariable ("userId") Long userId,
                                                  @PathVariable("companyId") Long companyId,
                                                  @PathVariable("accelerationId") Long accelerationId){
        Optional<Candidate> candidateOptional = candidateService.findById(userId, companyId, accelerationId);
        return ResponseEntity.ok(candidateMapper.map(candidateOptional.orElse(new Candidate())));
    }

    @ResponseStatus (HttpStatus.OK)
    @GetMapping
    public List<CandidateDTO> findAllByCompanyIdOrByAccelerationId(@RequestParam (required = false) Long companyId,
                                                                   @RequestParam (required = false) Long accelerationId){
        List<CandidateDTO> candidates = new ArrayList<>();

        if(companyId != null){
            return candidateMapper.map(candidateService.findByCompanyId(companyId));
        }
        if (accelerationId != null){
            return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
        }
        return candidates;
    }

}
