package com.example.tmf666.Repo;

import com.example.tmf666.Entity.ApplicationApprovalStatusChangeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationApprovalStatusChangeEventRepo extends JpaRepository<ApplicationApprovalStatusChangeEvent,Long> {
}
