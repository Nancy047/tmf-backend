package com.example.tmf666.Controller;

import com.example.tmf666.Entity.SettlementAccount;
import com.example.tmf666.Repo.SettlementAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/tmf-api/accountManagement/v4")
@CrossOrigin("*")  
public class SettlementController {

    @Autowired
    private SettlementAccountRepository settlementAccountRepository;

    @GetMapping("/getSettlementAccount/getAll")
    public ResponseEntity<List<SettlementAccount>> listSettlementAccount(
            @RequestParam(required = false) String fields, @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<SettlementAccount> page = settlementAccountRepository.findAll(pageable);
        return ResponseEntity.ok().header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements())).body(page.getContent());
    }

    @PostMapping("/settlementAccount/create")
    public String createSettlementAccount(@RequestBody SettlementAccount settlementAccount) {
        settlementAccountRepository.save(settlementAccount);
        return "created";
    }

    @GetMapping("/settlementAccount/{id}")
    public SettlementAccount retrieveSettlementAccount(@PathVariable Long id) {
        return settlementAccountRepository.findById(id).get();
    }

    @DeleteMapping("/deleteSettlementAccount/{id}")
    public String deleteSettlementAccount(@PathVariable Long id) {
        settlementAccountRepository.deleteById(id);
        return "Deleted";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SettlementAccount> updateSettlementAccount(@PathVariable Long id, @RequestBody SettlementAccount updatedSettlementAccount) {
        Optional<SettlementAccount> existingSettlementAccount = settlementAccountRepository.findById(id);

        if (existingSettlementAccount.isPresent()) {
            SettlementAccount settlementAccount = existingSettlementAccount.get();

            if (updatedSettlementAccount.getHref() != null) settlementAccount.setHref(updatedSettlementAccount.getHref());
            if (updatedSettlementAccount.getAccountType() != null) settlementAccount.setAccountType(updatedSettlementAccount.getAccountType());
            if (updatedSettlementAccount.getDescription() != null) settlementAccount.setDescription(updatedSettlementAccount.getDescription());
            if (updatedSettlementAccount.getLastModified() != null) settlementAccount.setLastModified(updatedSettlementAccount.getLastModified());
            if (updatedSettlementAccount.getName() != null) settlementAccount.setName(updatedSettlementAccount.getName());
            if (updatedSettlementAccount.getPaymentStatus() != null) settlementAccount.setPaymentStatus(updatedSettlementAccount.getPaymentStatus());
            if (updatedSettlementAccount.getState() != null) settlementAccount.setState(updatedSettlementAccount.getState());
            if (updatedSettlementAccount.getRelationshipType() != null) settlementAccount.setRelationshipType(updatedSettlementAccount.getRelationshipType());
            if (updatedSettlementAccount.getBillingDateShift() != null) settlementAccount.setBillingDateShift(updatedSettlementAccount.getBillingDateShift());
            if (updatedSettlementAccount.getBillingPeriod() != null) settlementAccount.setBillingPeriod(updatedSettlementAccount.getBillingPeriod());
            if (updatedSettlementAccount.getChargeDateOffset() != null) settlementAccount.setChargeDateOffset(updatedSettlementAccount.getChargeDateOffset());
            if (updatedSettlementAccount.getCreditDateOffset() != null) settlementAccount.setCreditDateOffset(updatedSettlementAccount.getCreditDateOffset());
            if (updatedSettlementAccount.getDateShift() != null) settlementAccount.setDateShift(updatedSettlementAccount.getDateShift());
            if (updatedSettlementAccount.getFrequency() != null) settlementAccount.setFrequency(updatedSettlementAccount.getFrequency());
            if (updatedSettlementAccount.isRef() != settlementAccount.isRef()) settlementAccount.setRef(updatedSettlementAccount.isRef());
            if (updatedSettlementAccount.getMailingDateOffset() != null) settlementAccount.setMailingDateOffset(updatedSettlementAccount.getMailingDateOffset());
            if (updatedSettlementAccount.getPaymentDueDateOffset() != null) settlementAccount.setPaymentDueDateOffset(updatedSettlementAccount.getPaymentDueDateOffset());
            if (updatedSettlementAccount.getReason() != null) settlementAccount.setReason(updatedSettlementAccount.getReason());
            if (updatedSettlementAccount.getIssuingJurisdiction() != null) settlementAccount.setIssuingJurisdiction(updatedSettlementAccount.getIssuingJurisdiction());
            if (updatedSettlementAccount.getCertificateNumber() != null) settlementAccount.setCertificateNumber(updatedSettlementAccount.getCertificateNumber());
            if (updatedSettlementAccount.getNumberOfPayments() != null) settlementAccount.setNumberOfPayments(updatedSettlementAccount.getNumberOfPayments());
            if (updatedSettlementAccount.getPaymentFrequency() != null) settlementAccount.setPaymentFrequency(updatedSettlementAccount.getPaymentFrequency());
            if (updatedSettlementAccount.getPlanType() != null) settlementAccount.setPlanType(updatedSettlementAccount.getPlanType());
            if (updatedSettlementAccount.getPriority() != null) settlementAccount.setPriority(updatedSettlementAccount.getPriority());
            if (updatedSettlementAccount.getStatus() != null) settlementAccount.setStatus(updatedSettlementAccount.getStatus());
            if (updatedSettlementAccount.getTotalAmount() != null) settlementAccount.setTotalAmount(updatedSettlementAccount.getTotalAmount());
            if (updatedSettlementAccount.getValidFor() != null) settlementAccount.setValidFor(updatedSettlementAccount.getValidFor());

            SettlementAccount updatedAccount = settlementAccountRepository.save(settlementAccount);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
