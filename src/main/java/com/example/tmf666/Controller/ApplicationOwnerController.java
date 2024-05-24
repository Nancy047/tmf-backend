package com.example.tmf666.Controller;

import com.example.tmf666.Entity.ApplicationOwner;
import com.example.tmf666.Repo.ApplicationOwnerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/applicationOwners")
public class ApplicationOwnerController {

    @Autowired
    private ApplicationOwnerRepo applicationOwnerRepository;

    @PostMapping("/create")
    public ResponseEntity<ApplicationOwner> createApplicationOwner(@RequestBody ApplicationOwner applicationOwner) {
        ApplicationOwner savedApplicationOwner = applicationOwnerRepository.save(applicationOwner);
        return new ResponseEntity<>(savedApplicationOwner, HttpStatus.CREATED);
    }
@GetMapping("/getAllOwner")
public ResponseEntity<List<ApplicationOwner>> getAllAplicationOwner(
        @RequestParam(required = false) String fields,
        @RequestParam(defaultValue = "0") int offset,
        @RequestParam(defaultValue = "10") int limit) {
    Pageable pageable = PageRequest.of(offset, limit);
    Page<ApplicationOwner> page = applicationOwnerRepository.findAll(pageable);
    return ResponseEntity.ok()
            .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
            .header("X-Total-Count", String.valueOf(page.getTotalElements()))
            .body(page.getContent());
}
    @GetMapping("Owner/{id}")
    public ApplicationOwner retrieveApplicationOwner(@PathVariable Long id) {
        return applicationOwnerRepository.findById(id).get();
    }
    @PatchMapping("/updateOwner/{id}")
    public ResponseEntity<ApplicationOwner> updateApplicationOwner(@PathVariable("id") Long id, @RequestBody ApplicationOwner updatedOwner) {
        // Retrieve the existing owner from your data source
        ApplicationOwner existingOwner = applicationOwnerRepository.findById(id).orElse(null);

        // Check if the existing owner exists
        if (existingOwner == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the existing owner with the fields from the updatedOwner
        BeanUtils.copyProperties(updatedOwner, existingOwner, "id");

        // Save the updated owner
        ApplicationOwner savedOwner = applicationOwnerRepository.save(existingOwner);

        return ResponseEntity.ok(savedOwner);
    }
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


}

