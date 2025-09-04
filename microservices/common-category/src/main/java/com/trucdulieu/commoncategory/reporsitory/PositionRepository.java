package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PositionRepository extends JpaRepository<Position,Long> {
    Page<Position> findByNameContainingIgnoreCase(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_POSITION,nativeQuery = true)
    Page<Position> findWithFilter(Long id, String name,  String description, Pageable paging);
}
