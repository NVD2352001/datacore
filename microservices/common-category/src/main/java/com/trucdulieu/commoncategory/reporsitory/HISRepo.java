package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.HIS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HISRepo extends JpaRepository<HIS, Long> {
    @Query (value = QueryValue.CHECKUP_HIS, nativeQuery = true)
    Page<HIS> findByIdAndName(
            Long id,
            String name,
            Pageable pageable);
}
