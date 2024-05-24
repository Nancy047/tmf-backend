package com.example.tmf666.Repo;

import com.example.tmf666.Entity.PartyAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyAccountRepository extends PagingAndSortingRepository<PartyAccount, Long> {
    PartyAccount save(PartyAccount partyAccount);

    Optional<PartyAccount> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
    // Additional custom queries can be added here if needed
}