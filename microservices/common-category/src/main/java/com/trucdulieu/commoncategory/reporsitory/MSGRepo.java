package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.MSG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MSGRepo extends JpaRepository<MSG, Long> {
    @Query (value = QueryValue.CHECK_MSG, nativeQuery = true)
    Page<MSG> findIdNameCode(Long id,
                             String name,
                             String code,
                             String description,
                             Pageable pageable);
//            @Param("id") Long id,
//            @Param("name") String name,
//            @Param("code") String code,
//            @Param("description") String description,
//            Pageable pageable);
}
