package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trucdulieu.commoncategory.model.entity.Bank;
import org.springframework.data.jpa.repository.Query;

public interface BankRepo extends JpaRepository<Bank, Long> {
    Page<Bank> findByNameContainingIgnoreCase(String name, Pageable paging);

    @Query(value = QueryValue.CHECKUP_BANK, nativeQuery = true)
    Page<Bank> findWithFilter(Long id, String name, String description, String code, String bin, String shortName, String swiftCode, Pageable paging);

}
