package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trucdulieu.commoncategory.model.entity.Ward;
import org.springframework.data.jpa.repository.Query;

public interface WardRepo extends JpaRepository<Ward, Long> {
    @Query(value = QueryValue.CHECKUP_WARD, nativeQuery = true)
    Page<Ward> findByIdAndName(Long id, String name, String description ,Pageable pageable);
}
