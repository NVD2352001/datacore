package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.DiagnosticImaging;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiagnosticImagingRepository extends JpaRepository<DiagnosticImaging,Long> {
    Page<DiagnosticImaging> findByNameContainingIgnoreCase(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_DIAGNOSICIMAGING,nativeQuery = true)
    Page<DiagnosticImaging> findWithFilter(Long id, String name,  String description, Pageable paging);
}
