package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.Icd10;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Icd10Repo extends JpaRepository<Icd10, Long> {
    Page<Icd10> findByName(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_ICD10, nativeQuery = true)
    Page<Icd10> findWithFilter(Long id, String name, String code, String chapter, String group, Pageable paging);
}
