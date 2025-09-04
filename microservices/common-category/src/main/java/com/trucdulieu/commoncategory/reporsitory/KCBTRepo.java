package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.KCBT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KCBTRepo extends JpaRepository<KCBT, Long> {
    @Query(value = QueryValue.CHECK_KCBT, nativeQuery = true)
    Page<KCBT> findIdNameDescKCBT(Long id, String name, String description, Pageable pageable);
}
