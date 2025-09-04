package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnitRepo extends JpaRepository<Unit, Long> {
    Page<Unit> findByName(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_UNIT, nativeQuery = true)
    Page<Unit> findWithFilter(Long id, String name, String description,Pageable paging);
}
