package com.example.tmf666.Repo;

import com.example.tmf666.Entity.BillFormat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillFormatRepository extends PagingAndSortingRepository<BillFormat, Long> {
    BillFormat save(BillFormat billFormat);

    Optional<BillFormat> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
    // Additional custom queries can be added here if needed
}
