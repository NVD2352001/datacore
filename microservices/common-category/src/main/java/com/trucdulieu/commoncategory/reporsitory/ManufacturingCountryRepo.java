package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.ManufacturingCountry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManufacturingCountryRepo extends JpaRepository<ManufacturingCountry, Long> {
    Page<ManufacturingCountry> findByName(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_MANUFACTURINGCOUNTRY, nativeQuery = true)
    Page<ManufacturingCountry> findWithFilter(Long id, String name, String description,Pageable paging);
}
