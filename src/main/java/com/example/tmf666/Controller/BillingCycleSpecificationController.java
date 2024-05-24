package com.example.tmf666.Controller;

import com.example.tmf666.Entity.BillingCycleSpecification;
import com.example.tmf666.Repo.BillingCycleSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/tmf-api/accountManagement/v4")
@CrossOrigin("*")
public class BillingCycleSpecificationController {

    @Autowired
    private BillingCycleSpecificationRepository billingCycleSpecificationRepository;

    @PostMapping("/billingCycle/create")
    public ResponseEntity<BillingCycleSpecification> createBillingCycleSpecification(@RequestBody BillingCycleSpecification billingCycleSpecification) {
      billingCycleSpecification.setBillingPeriod(billingCycleSpecification.getBillingPeriod());
      billingCycleSpecification.setDescription(billingCycleSpecification.getDescription());
      billingCycleSpecification.setChargeDateOffset(billingCycleSpecification.getChargeDateOffset());
      billingCycleSpecification.setFrequency(billingCycleSpecification.getFrequency());
      billingCycleSpecification.setCreditDateOffset(billingCycleSpecification.getCreditDateOffset());
        BillingCycleSpecification savedBillingCycleSpecification = billingCycleSpecificationRepository.save(billingCycleSpecification);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBillingCycleSpecification);
    }

    @GetMapping("/billingCycle/getAll")
    public ResponseEntity<List<BillingCycleSpecification>> listBillingCycleSpecification(
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(offset, limit);
        Page<BillingCycleSpecification> page = billingCycleSpecificationRepository.findAll(pageable);

        return ResponseEntity.ok()
                .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements()))
                .body(page.getContent());
    }

    @GetMapping("/billingCycle/{id}")
    public ResponseEntity<BillingCycleSpecification> getBillingCycleSpecificationById(@PathVariable Long id) {
        Optional<BillingCycleSpecification> billingCycleSpecification = billingCycleSpecificationRepository.findById(id);
        return billingCycleSpecification.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a BillingCycleSpecification
    @PutMapping("/billingCycle/{id}")
    public ResponseEntity<BillingCycleSpecification> updateBillingCycleSpecification(@PathVariable Long id, @RequestBody BillingCycleSpecification updatedBillingCycleSpecification) {
        return billingCycleSpecificationRepository.findById(id)
                .map(billingCycleSpecification -> {

                    billingCycleSpecification.setName(updatedBillingCycleSpecification.getName());
                    billingCycleSpecification.setDescription(updatedBillingCycleSpecification.getDescription());
                    billingCycleSpecification.setBillingPeriod(billingCycleSpecification.getBillingPeriod());
                    billingCycleSpecification.setDescription(billingCycleSpecification.getDescription());

                    billingCycleSpecification.setChargeDateOffset(billingCycleSpecification.getChargeDateOffset());
                    billingCycleSpecification.setFrequency(billingCycleSpecification.getFrequency());
                    billingCycleSpecification.setCreditDateOffset(billingCycleSpecification.getCreditDateOffset());
                    billingCycleSpecification.setBillingPeriod(updatedBillingCycleSpecification.getBillingPeriod());


                    BillingCycleSpecification savedBillingCycleSpecification = billingCycleSpecificationRepository.save(billingCycleSpecification);
                    return ResponseEntity.ok(savedBillingCycleSpecification);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a BillingCycleSpecification
    @DeleteMapping("/billingCycle/{id}")
    public ResponseEntity<Void> deleteBillingCycleSpecification(@PathVariable Long id) {
        if (billingCycleSpecificationRepository.existsById(id)) {
            billingCycleSpecificationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
