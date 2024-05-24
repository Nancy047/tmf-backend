package com.example.tmf666.Service;

import com.example.tmf666.Entity.Application;
import com.example.tmf666.Entity.ApplicationApproval;
import com.example.tmf666.Pojo.UpdateApplicationRequest;
import com.example.tmf666.Repo.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(String id) {
        return applicationRepository.findById(id);
    }

    public Optional<Application> updateApplication(String id, UpdateApplicationRequest updateApplicationRequest) {
        Optional<Application> existingApplicationOptional = applicationRepository.findById(id);
        if (existingApplicationOptional.isPresent()) {
            Application existingApplication = existingApplicationOptional.get();
            existingApplication.setType(updateApplicationRequest.getType());
            existingApplication.setOperationalState(updateApplicationRequest.getOperationalState());


            return Optional.of(applicationRepository.save(existingApplication));
        } else {
            return Optional.empty();
        }
    }
}
