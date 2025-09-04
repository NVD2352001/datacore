package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.AnalyzerMachine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnalyzerMachineRepository extends JpaRepository<AnalyzerMachine, Long> {
    @Query(value = QueryValue.FILTER_ANALYZERMACHINE, nativeQuery = true)
    Page<AnalyzerMachine> findWithFilter(@Param("id") Long id, @Param("name") String name, @Param("machine_code") String machineCode, Pageable pageable);
}
