package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.MedicalRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicalRouteRepo extends JpaRepository<MedicalRoute, Long> {
    @Query(value = QueryValue.CHECK_MEDICAL_ROUTE, nativeQuery = true)
    Page<MedicalRoute> findIdNameDesc(Long id,
                                      String name,
                                      String description,
                                      Pageable pageable);
}
