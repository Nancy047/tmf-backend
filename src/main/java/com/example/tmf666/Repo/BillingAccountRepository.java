package com.example.tmf666.Repo;

import com.example.tmf666.Entity.BillingAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingAccountRepository extends PagingAndSortingRepository<BillingAccount, Long> {
    BillingAccount save(BillingAccount billingAccount);

    Optional<BillingAccount> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);
    // Additional custom queries can be added here if needed
}
