package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    public CompanyController(CompanyServiceInterface companyServiceInterface) {
        this.companyServiceInterface = companyServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(companyServiceInterface.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    @GetMapping
    public ResponseEntity<List<Company>> findByAccelerationIdOrByUserId(@RequestParam (required = false) Long accelerationId,
                                                        @RequestParam (required = false) Long userId){
        List<Company> companies = new ArrayList<>();

        if(accelerationId != null){
           companies.addAll(companyServiceInterface.findByAccelerationId(accelerationId));
        }
        if(userId != null){
           companies.addAll(companyServiceInterface.findByUserId(userId));
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/ByAcceleration/{id}")
    public List<Company> findByAccelerationId(@PathVariable("id") Long accelerationId){
        return this.companyServiceInterface.findByAccelerationId(accelerationId);
    }

    @GetMapping("/ByUser/{id}")
    public  List<Company> findByUserId(@PathVariable("id") Long userId){
        return this.companyServiceInterface.findByUserId(userId);
    }
}
