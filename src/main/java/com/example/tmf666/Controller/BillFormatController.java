package com.example.tmf666.Controller;

import com.example.tmf666.Entity.BillFormat;
import com.example.tmf666.Entity.FinancialAccount;
import com.example.tmf666.Repo.BillFormatRepository;
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
@CrossOrigin("*")
public class BillFormatController {

    @Autowired
    private BillFormatRepository billFormatRepository;

    @PostMapping("/billFormat/create")
    public String createBillFormat(@RequestBody BillFormat billFormatCreate) {
        billFormatRepository.save(billFormatCreate);
        return "created";
    }


    @GetMapping("/billFormat/getAll")
    public ResponseEntity<List<BillFormat>> listBillFormat(
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(offset, limit);
        Page<BillFormat> page = billFormatRepository.findAll(pageable);

        return ResponseEntity.ok()
                .header("X-Result-Count", String.valueOf(page.getNumberOfElements()))
                .header("X-Total-Count", String.valueOf(page.getTotalElements()))
                .body(page.getContent());
    }

    @GetMapping("/billFormat/{id}")
    public ResponseEntity<BillFormat> getBillFormatById(@PathVariable Long id) {
        Optional<BillFormat> billFormat = billFormatRepository.findById(id);
        return billFormat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PatchMapping("/billFormat/{id}")
    public ResponseEntity<BillFormat> updateBillFormat(@PathVariable Long id, @RequestBody BillFormat updatedBillFormat) {
        Optional<BillFormat> existingFinancialAccount = billFormatRepository.findById(id);
        if (existingFinancialAccount.isPresent()) {
            BillFormat financialAccount = existingFinancialAccount.get();
            financialAccount.setName(updatedBillFormat.getName());
            financialAccount.setDuration(updatedBillFormat.getDuration());
            financialAccount.setDescription(updatedBillFormat.getDescription());
            financialAccount.setHref(updatedBillFormat.getHref());
            financialAccount.setCreationDate(updatedBillFormat.getCreationDate());
            BillFormat updatedAccount = billFormatRepository.save(updatedBillFormat);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/billFormat/{id}")
    public ResponseEntity<Void> deleteBillFormat(@PathVariable Long id) {
        if (billFormatRepository.existsById(id)) {
            billFormatRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}