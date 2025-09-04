package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.JobTitl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobTileRepository  extends JpaRepository<JobTitl,Long> {
    Page<JobTitl> findByNameContainingIgnoreCase(String name, Pageable paging);
    @Query(value = QueryValue.CHECKUP_JOBTITL,nativeQuery = true)
    Page<JobTitl> findWithFilter(Long id, String name,  String description, Pageable paging);
}
