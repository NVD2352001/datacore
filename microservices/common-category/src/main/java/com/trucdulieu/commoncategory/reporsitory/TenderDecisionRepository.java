package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.TenderDecision;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TenderDecisionRepository extends JpaRepository<TenderDecision, Long>{
    @Query(value = QueryValue.CHECKUP_TENDER_DECISION, nativeQuery = true)
    Page<TenderDecision> findWithFilter(Long id, String name, String unit_name, String tenderNumber, String decision, String decisionDate, Pageable paging);
}