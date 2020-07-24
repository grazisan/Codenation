package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;

    public AccelerationController(AccelerationServiceInterface accelerationServiceInterface) {
        this.accelerationServiceInterface = accelerationServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity <Acceleration> findById(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(accelerationServiceInterface.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    @GetMapping
    public ResponseEntity <List<Acceleration>> findAllByCompanyId(@RequestParam Long companyId){
        return ResponseEntity.ok(accelerationServiceInterface.findByCompanyId(companyId));
    }

}
