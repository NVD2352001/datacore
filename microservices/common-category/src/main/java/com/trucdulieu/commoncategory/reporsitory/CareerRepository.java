package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Career;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CareerRepository extends JpaRepository<Career,Long> {
    Page<Career> findByNameContainingIgnoreCase(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_CAREER,nativeQuery = true)
    Page<Career> findWithFilter(Long id, String name,  String description, Pageable paging);
}
