package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.ClassificationOfTechnicalServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassificationOfTechnicalServicesRepository extends JpaRepository<ClassificationOfTechnicalServices, Long> {
    @Query(value = QueryValue.FILTER_TECHNICALSERVICES, nativeQuery = true)
    Page<ClassificationOfTechnicalServices> findWithFilter(Long id, String name, String code, Pageable pageable);

}
