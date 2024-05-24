package com.example.tmf666.Repo;

import com.example.tmf666.Entity.Application;
import com.example.tmf666.Entity.ApplicationApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,String> {
}
