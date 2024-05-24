package com.example.tmf666.Controller;

import com.example.tmf666.Entity.BillFormat;
import com.example.tmf666.Entity.BillingAccount;
import com.example.tmf666.Repo.BillingAccountRepository;
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
@CrossOrigin("*")
public class BillingAccountController {

    @Autowired
    private BillingAccountRepository billingAccountRepository;


    @PostMapping("/billingAcccount/create")
    public ResponseEntity<BillingAccount> createBillingAccount(@RequestBody BillingAccount billingAccount) {
        BillingAccount savedBillingAccount = billingAccountRepository.save(billingAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBillingAccount);
    }

    @GetMapping("/billingAcccount/getAll")
    public ResponseEntity<List<BillingAccount>> listBillingAccount(
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(offset, limit);
        Page<BillingAccount> page = billingAccountRepository.findAll(pageable);

        return ResponseEntity.ok()
                .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements()))
                .body(page.getContent());
    }

    @PatchMapping("BillingAccount/{id}")
    public ResponseEntity<BillingAccount> updateFinancialAccount(@PathVariable Long id, @RequestBody BillingAccount updatedBillingAccount) {
        Optional<BillingAccount> existingFinancialAccount = billingAccountRepository.findById(id);

        if (existingFinancialAccount.isPresent()) {
            BillingAccount billingAccount = existingFinancialAccount.get();
            billingAccount.setHref(updatedBillingAccount.getHref());
            billingAccount.setAccountType(updatedBillingAccount.getAccountType());
            billingAccount.setDescription(updatedBillingAccount.getDescription());
         billingAccount.setLastModifiedDate(updatedBillingAccount.getLastModifiedDate());
            billingAccount.setName(updatedBillingAccount.getName());
            billingAccount.setState(updatedBillingAccount.getState());

            return ResponseEntity.ok(updatedBillingAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/billingAcccount/{id}")
    public ResponseEntity<Object> getBillingAccountById(@PathVariable Long id) {
        Optional<Object> billingAccount = Optional.ofNullable(billingAccountRepository.findById(id));
        return billingAccount.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/billingAcccount/{id}")
    public ResponseEntity<Void> deleteBillingAccount(@PathVariable Long id) {
        if (billingAccountRepository.existsById(id)) {
            billingAccountRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}