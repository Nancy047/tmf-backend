package com.example.tmf666.Controller;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.tmf666.Entity.Hub;
import com.example.tmf666.Repo.HubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/hub")
@CrossOrigin("*")
public class HubController {

    @Autowired
    private HubRepo hubRepo;

    private Map<Long, Hub> hubStorage = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    @PostMapping("/dataCreate")
    public ResponseEntity<Hub> createHub(@RequestBody Hub hub) {
        long id = counter.incrementAndGet();
        hub.setId(id);
        hubStorage.put(id, hub);
        hubRepo.save(hub);
        return new ResponseEntity<>(hub, HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteHub(@PathVariable long id) {
        if (hubStorage.containsKey(id)) {
            hubStorage.remove(id);
            hubRepo.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
