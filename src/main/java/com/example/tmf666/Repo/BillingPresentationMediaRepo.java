package com.example.tmf666.Repo;

import com.example.tmf666.Entity.BillingPresentationMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingPresentationMediaRepo  extends JpaRepository<BillingPresentationMedia, Long> {

}

