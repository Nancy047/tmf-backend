package com.example.tmf666.Controller;

import com.example.tmf666.Entity.EventSubscription;
import com.example.tmf666.Repo.EventSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tmf-api/accountManagement/v4")
public class EventSubscriptionController {

    @Autowired
    private EventSubscriptionRepository eventSubscriptionRepository;


    @PostMapping("/eventSubscription/create")
    public ResponseEntity<EventSubscription> createEventSubscription(@RequestBody EventSubscription eventCreate) {
        EventSubscription eventSubscription = new EventSubscription();
        eventSubscription.setCallback(eventCreate.getCallback());
        eventSubscription.setQuery(eventCreate.getQuery());
        EventSubscription savedPartyAccount = eventSubscriptionRepository.save(eventCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPartyAccount);
    }


    @GetMapping("/eventSubscription/getAll")
    public ResponseEntity<List<EventSubscription>> listPartyAccount(
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(offset, limit);
        Page<EventSubscription> page = eventSubscriptionRepository.findAll(pageable);

        return ResponseEntity.ok()
                .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements()))
                .body(page.getContent());
    }

    @GetMapping("/eventSubscription/{id}")
    public ResponseEntity<EventSubscription> getEventSubscription(@PathVariable Long id) {
        Optional<EventSubscription> partyAccount = eventSubscriptionRepository.findById(id);
        return partyAccount.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PatchMapping("/eventSubscription/{id}")
    public ResponseEntity<EventSubscription> updateEventSubscription(@PathVariable Long id, @RequestBody EventSubscription eventSubscriptionUpdate) {
        return eventSubscriptionRepository.findById(id)
                .map(eventSubscription -> {
                    eventSubscription.setCallback(eventSubscriptionUpdate.getCallback());
                    eventSubscription.setQuery(eventSubscriptionUpdate.getQuery());
                    EventSubscription savedPartyAccount = eventSubscriptionRepository.save(eventSubscription);
                    return ResponseEntity.ok(savedPartyAccount);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eventSubscription/{id}")
    public ResponseEntity<Void> deleteEventSubscription(@PathVariable Long id) {
        if (eventSubscriptionRepository.existsById(id)) {
            eventSubscriptionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

