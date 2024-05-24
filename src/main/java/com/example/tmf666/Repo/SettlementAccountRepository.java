package com.example.tmf666.Repo;


import com.example.tmf666.Entity.SettlementAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementAccountRepository extends JpaRepository<SettlementAccount, Long> {

}
