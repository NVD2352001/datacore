package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.SickBed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SickBedRepo extends JpaRepository<SickBed, Long> {
    Page<SickBed> findByName(String name, Pageable pageable);
    @Query(value = QueryValue.CHECKUP_SICKBED,nativeQuery = true)
    Page<SickBed> findWithFilter(Long id, String name, Pageable pageable);
}
