package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
    Page<Manufacturer> findByName(String name, Pageable pageable);
    @Query(value = QueryValue.CHECKUP_MANUFACTURER,nativeQuery = true)
    Page<Manufacturer> findWithFilter(Long id, String name, String companyName, String description,Pageable pageable);
}
