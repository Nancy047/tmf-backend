package com.example.tmf666.Controller;

import com.example.tmf666.Entity.BillFormat;
import com.example.tmf666.Entity.PartyAccount;

import com.example.tmf666.Repo.PartyAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tmf-api/accountManagement/v4")
public class PartyAccountController {

    @Autowired
    private PartyAccountRepository partyAccountRepository;

    @PostMapping("/partyAccount/create")
    public String createBillFormat(@RequestBody PartyAccount partyAccount) {
        partyAccountRepository.save(partyAccount);
        return "created";
    }
    @GetMapping("/partyAccount/getAll")
    public ResponseEntity<List<PartyAccount>> listPartyAccount(
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(offset, limit);
        Page<PartyAccount> page = partyAccountRepository.findAll(pageable);

        return ResponseEntity.ok()
                .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements()))
                .body(page.getContent());
    }

    @GetMapping("/partyAccount/{id}")
    public ResponseEntity<PartyAccount> getPartyAccountById(@PathVariable Long id) {
        Optional<PartyAccount> partyAccount = partyAccountRepository.findById(id);
        return partyAccount.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PatchMapping("/partyAccount/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<PartyAccount> updateFinancialAccount(@PathVariable Long id, @RequestBody PartyAccount updatedPartyAccount) {
        Optional<PartyAccount> existingFinancialAccount = partyAccountRepository.findById(id);

        if (existingFinancialAccount.isPresent()) {
            PartyAccount partyAccount = existingFinancialAccount.get();

            // Update the fields of the existing partyAccount with the values from the updatedFinancialAccount
            partyAccount.setHref(updatedPartyAccount.getHref());

            partyAccount.setDescription(updatedPartyAccount.getDescription());

            partyAccount.setName(updatedPartyAccount.getName());


            return ResponseEntity.ok(updatedPartyAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/partyAccount/{id}")
    public ResponseEntity<Void> deletePartyAccount(@PathVariable Long id) {
        if (partyAccountRepository.existsById(id)) {
            partyAccountRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
