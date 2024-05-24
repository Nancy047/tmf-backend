package com.example.tmf666.Controller;

import com.example.tmf666.Entity.*;
import com.example.tmf666.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class NotificationListenerController {
@Autowired
private ApplicationCreateEventRepo applicationCreateEventRepo;

    @Autowired
    private  ApplicationApprovalStatusChangeEventRepo applicationApprovalStatusChangeEventRepo;
    @Autowired
    private ApplicationOwnerAttributeValueChangeEventRepository applicationOwnerAttributeValueChangeEventrepository;
    @Autowired
    private ApiProductOrderErrorMessageEventRepository repository;
    @Autowired
    private ApplicationOwnerCreateEventRepository applicationOwnerCreateEventrepository;
    @Autowired
    private ApiProductOrderStateChangeEventRepository apiProductOrderStateChangeEventrepository;
@Autowired
private ApplicationOwnerApprovalStatusChangeEventRepo applicationOwnerApprovalStatusChangeEventRepo;
    @Autowired
    private ApiProductOrderAttributeValueChangeEventRepository apiProductOrderAttributeValueChangeEvent;
    @PostMapping("/create/ErrorEvent")
    public ResponseEntity<ApiProductOrderErrorMessageEvent> createErrorEvent(@RequestBody ApiProductOrderErrorMessageEvent event) {
        ApiProductOrderErrorMessageEvent savedEvent = repository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }


    @PostMapping("/create/ChangeEvent")
    public ResponseEntity<ApiProductOrderStateChangeEvent> createChangeEvent(@RequestBody ApiProductOrderStateChangeEvent event) {
        ApiProductOrderStateChangeEvent savedEvent = apiProductOrderStateChangeEventrepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }


    @PostMapping("/create/ApplicationOwnerEvent")
    public ResponseEntity<ApplicationOwner> createApplicationOwnerEvent(@RequestBody ApplicationOwner event) {
        ApplicationOwner savedEvent = applicationOwnerCreateEventrepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PostMapping("/create/ApplicationOwnerAttributeValueChangeEvent")
    public ResponseEntity<ApplicationOwnerAttributeValueChangeEvent> createApplicationOwnerAttributeValueChangeEvent(@RequestBody ApplicationOwnerAttributeValueChangeEvent event) {
        ApplicationOwnerAttributeValueChangeEvent savedEvent = applicationOwnerAttributeValueChangeEventrepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }
    @PostMapping("/create/ApplicationOwnerApprovalStatusChangeEvent")
    public ResponseEntity<ApplicationOwnerApprovalStatusChangeEvent> createApplicationOwnerApprovalStatusChangeEvent(@RequestBody ApplicationOwnerApprovalStatusChangeEvent event) {
        ApplicationOwnerApprovalStatusChangeEvent savedEvent = applicationOwnerApprovalStatusChangeEventRepo.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }
    @PostMapping("/create/ApiProductOrderAttributeValueChangeEvent")
    public ResponseEntity<ApiProductOrderAttributeValueChangeEvent> createApiProductOrderAttributeValueChangeEvent(@RequestBody ApiProductOrderAttributeValueChangeEvent event) {
        ApiProductOrderAttributeValueChangeEvent savedEvent = apiProductOrderAttributeValueChangeEvent.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }
    @PostMapping("/create/applicationApprovalStatusChangeEvent")
    public ResponseEntity<ApplicationApprovalStatusChangeEvent> createEvent(@RequestBody ApplicationApprovalStatusChangeEvent event) {
        ApplicationApprovalStatusChangeEvent savedEvent = applicationApprovalStatusChangeEventRepo.save(event);
     return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PostMapping
    public ResponseEntity<ApplicationCreateEvent> createEvent(
            @RequestBody ApplicationCreateEvent event) {
        ApplicationCreateEvent savedEvent = applicationCreateEventRepo.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }
}

