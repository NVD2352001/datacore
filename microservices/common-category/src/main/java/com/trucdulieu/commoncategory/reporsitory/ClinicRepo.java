package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Clinic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClinicRepo extends JpaRepository<Clinic, Long> {

    Page<Clinic> findByName(String name, Pageable pageable);
    @Query(value = QueryValue.CHECKUP_CLINIC,nativeQuery = true)
    Page<Clinic> findWithFilter(Long id, String name, Pageable pageable);
}
