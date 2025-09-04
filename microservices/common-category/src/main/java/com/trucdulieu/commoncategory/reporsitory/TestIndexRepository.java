package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.TestIndex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestIndexRepository extends JpaRepository<TestIndex,Long> {
    Page<TestIndex> findByNameContainingIgnoreCase(String name, Pageable paging);

    @Query(value = QueryValue.CHECKUP_TESTINDEX, nativeQuery = true)
    Page<TestIndex> findWithFilter(Long id, String name, String description, Double referenceValue, Double unit, Pageable paging);
}
