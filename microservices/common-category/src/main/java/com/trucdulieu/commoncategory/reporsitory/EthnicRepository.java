package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Ethnic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EthnicRepository extends JpaRepository<Ethnic, Long> {
    @Query(value = QueryValue.CHECKUP_ETHNIC, nativeQuery = true)
    Page<Ethnic> findByEthnicIdAndNameWithPagination(Long id, String name, Pageable pageable);
}
