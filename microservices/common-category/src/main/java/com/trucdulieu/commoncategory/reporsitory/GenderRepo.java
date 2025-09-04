package com.trucdulieu.commoncategory.reporsitory;
import com.trucdulieu.commoncategory.config.QueryValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trucdulieu.commoncategory.model.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface GenderRepo extends JpaRepository<Gender, Long> {
    @Query(value = QueryValue.CHECKUP_GENDER,nativeQuery = true)
    Page<Gender> findWithFilter(Long id,String name, String description, Pageable pageable);
    Page<Gender> findByNameContaining(String name ,Pageable pageable);
}
