package com.example.tmf666.Controller;



import java.util.List;

import com.example.tmf666.Entity.BillingPresentationMedia;
import com.example.tmf666.Repo.BillingPresentationMediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tmf-api/accountManagement/v4/billingPresentationMedia")
@CrossOrigin("*")
public class BillingMediaController {

    @Autowired
    private BillingPresentationMediaRepo billMediaRepo;

    @GetMapping("/list/billingPresentationMedia")
    public ResponseEntity<List<BillingPresentationMedia>> listBillingMedia(
            @RequestParam(required = false) String fields, @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<BillingPresentationMedia> page = billMediaRepo.findAll(pageable);
        return ResponseEntity.ok().header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements())).body(page.getContent());
    }

    @PostMapping("/create/billingPresentationMedia")
    public String createBillingMedia(@RequestBody BillingPresentationMedia billMedia) {
        billMediaRepo.save(billMedia);
        return "created";
    }

    @GetMapping("/billingPresentationMedia/{id}")
    public BillingPresentationMedia retrieveBillingMedia(@PathVariable Long id) {
        return billMediaRepo.findById(id).get();
    }

    @DeleteMapping("/deleteBillingMedia/{id}")
    public String deleteBillingMedia(@PathVariable Long id) {
        billMediaRepo.deleteById(id);
        return "Deleted";
    }

    @PutMapping("/billingPresentationMedia/{id}")
    public ResponseEntity<BillingPresentationMedia> updateBillingPresentationMedia(@PathVariable Long id,
                                                                                   @RequestBody BillingPresentationMedia updatedBillingMedia) {
        return billMediaRepo.findById(id).map(billingCycleSpecification -> {
            billingCycleSpecification.setName(updatedBillingMedia.getName());
            billingCycleSpecification.setDescription(updatedBillingMedia.getDescription());
            BillingPresentationMedia savedBillingCycleSpecification = billMediaRepo.save(billingCycleSpecification);
            return ResponseEntity.ok(savedBillingCycleSpecification);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
