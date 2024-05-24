package com.example.tmf666.Controller;


import java.util.List;
import java.util.Optional;


import com.example.tmf666.Entity.FinancialAccount;
import com.example.tmf666.Repo.FinancialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/tmf-api/accountManagement/v4")
@CrossOrigin("*")
public class FinancialController {

    @Autowired
    private FinancialAccountRepository financialAccountRepository;

    @GetMapping("/listfinancialAccount/{id}")
    public ResponseEntity<List<FinancialAccount>> listFinancialAccount(
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<FinancialAccount> page = financialAccountRepository.findAll(pageable);
        return ResponseEntity.ok()
                .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements()))
                .body(page.getContent());
    }
    @PostMapping("/financialAccount/createFinancialAccount")
    public String createFinancialAccount(@RequestBody FinancialAccount financialAccount) {
        financialAccountRepository.save(financialAccount);
        return "created";
    }
    @GetMapping("/financialAccount/{id}")
    public FinancialAccount retrieveFinancialAccount(@PathVariable Long id) {
        return financialAccountRepository.findById(id).get();
    }

    @PatchMapping("/financialAccount/{id}")
    public ResponseEntity<FinancialAccount> updateFinancialAccount(@PathVariable Long id, @RequestBody FinancialAccount updatedFinancialAccount) {
        Optional<FinancialAccount> existingFinancialAccount = financialAccountRepository.findById(id);

        if (existingFinancialAccount.isPresent()) {
            FinancialAccount financialAccount = existingFinancialAccount.get();


            financialAccount.setHref(updatedFinancialAccount.getHref());
            financialAccount.setAccountType(updatedFinancialAccount.getAccountType());
            financialAccount.setDescription(updatedFinancialAccount.getDescription());
            financialAccount.setLastModified(updatedFinancialAccount.getLastModified());
            financialAccount.setName(updatedFinancialAccount.getName());
            financialAccount.setState(updatedFinancialAccount.getState());
            financialAccount.setMediumType(updatedFinancialAccount.getMediumType());
            financialAccount.setPreferred(updatedFinancialAccount.isPreferred());
            financialAccount.setRole(updatedFinancialAccount.getRole());
            financialAccount.setRelationshipType(updatedFinancialAccount.getRelationshipType());
            financialAccount.setContactName(updatedFinancialAccount.getContactName());
            financialAccount.setContactType(updatedFinancialAccount.getContactType());
            financialAccount.setPartyRoleType(updatedFinancialAccount.getPartyRoleType());
            financialAccount.setReason(updatedFinancialAccount.getReason());
            financialAccount.setIssuingJurisdiction(updatedFinancialAccount.getIssuingJurisdiction());
            financialAccount.setCertificateNumber(updatedFinancialAccount.getCertificateNumber());
            financialAccount.setAccountBalances(updatedFinancialAccount.getAccountBalances());
            FinancialAccount updatedAccount = financialAccountRepository.save(financialAccount);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteFinancialAccount/{id}")
    public String deleteFinancialAccount(@PathVariable Long id) {
        financialAccountRepository.deleteById(id);
        return "Deleted";
    }

}
