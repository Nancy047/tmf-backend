package com.example.tmf666.Repo;


import com.example.tmf666.Entity.ApplicationCreateEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationCreateEventRepo extends JpaRepository<ApplicationCreateEvent, Long> {
}

