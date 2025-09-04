package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.TestCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCatalogRepository extends JpaRepository<TestCatalog, Long> {
    @Query(value = QueryValue.CHECKUP_TEST_CATALOG, nativeQuery = true)
    Page<TestCatalog> filterTestCatalog(Long id, String code, String index, String name, Pageable pageable);
}
