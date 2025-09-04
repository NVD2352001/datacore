package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.ImageDiagnosticMachine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageDiagnosticMachineRepository extends JpaRepository<ImageDiagnosticMachine,Long> {
    Page<ImageDiagnosticMachine> findByNameContainingIgnoreCase(String name, Pageable paging);

    @Query(value = QueryValue.CHECKUP_IMAGEDIAGNOSTICMACHINE, nativeQuery = true)
    Page<ImageDiagnosticMachine> findWithFilter(Long id, String name, String description, String code, Pageable paging);
}
