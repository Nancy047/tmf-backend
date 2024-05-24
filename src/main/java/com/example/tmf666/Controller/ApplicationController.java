package com.example.tmf666.Controller;

import com.example.tmf666.Entity.Application;
import com.example.tmf666.Entity.ApplicationApproval;
import com.example.tmf666.Pojo.ApplicationFieldSelection;
import com.example.tmf666.Pojo.ApplicationResponse;
import com.example.tmf666.Pojo.UpdateApplicationRequest;
import com.example.tmf666.Service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
            private ApplicationService applicationService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/getAllApplication")
    public List<Application> findAllApplication() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/getAllApplicationBasedFields")
    public List<ApplicationFieldSelection> findAllApplicationSelectionFields() {
        List<Application> application = applicationService.getAllApplications();
        List<ApplicationFieldSelection> applicationFieldResponse = application
                .stream()
                .map(res -> modelMapper.map(res, ApplicationFieldSelection.class))
                .collect(Collectors.toList());
        return applicationFieldResponse;
    }

    @PostMapping("/createApplication")
    public ApplicationResponse createApplication(@RequestBody Application application) {
        Application applicationResponse = applicationService.createApplication(application);
        return modelMapper.map(applicationResponse, ApplicationResponse.class);

    }

    @GetMapping("/findApplicationFieldsById/{id}")
    public ApplicationResponse findApplicationById(@PathVariable(required = true) String id) {
        Optional<Application> application = applicationService.getApplicationById(id);
        ApplicationResponse applicationResponse = modelMapper.map(application, ApplicationResponse.class);
        return applicationResponse;
    }

    @GetMapping("/findApplicationById/{id}")
    public Optional<Application> findApplicationFieldsById(@PathVariable(required = true) String id) {
        return applicationService.getApplicationById(id);
    }

    @PatchMapping("/updateApplicationById/{id}")
    public ResponseEntity<Application> updateApplicationById(@PathVariable(required = true) String id, @RequestBody UpdateApplicationRequest updateApplicationRequest) {
        Optional<Application> updatedApp = applicationService.updateApplication(id, updateApplicationRequest);
        return updatedApp.map(application -> new ResponseEntity<>(application, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}