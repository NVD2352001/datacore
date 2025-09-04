package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.HTSS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HTSSRepo extends JpaRepository<HTSS, Long> {
    @Query(value = QueryValue.CHECK_HTSS, nativeQuery = true)
    Page<HTSS> findIdNameDescHTSS (Long id, String name, String code, String description, Pageable pageable);
}
