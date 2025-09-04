package com.trucdulieu.commoncategory.reporsitory;

import com.trucdulieu.commoncategory.config.QueryValue;
import com.trucdulieu.commoncategory.model.entity.PackageType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PackageTypeRopository extends JpaRepository<PackageType, Long> {
    @Query(value = QueryValue.CHECKUP_PACKAGE_TYPE, nativeQuery = true)
    Page<PackageType> findWithFilter(Long id, String name, String code, Pageable paging);
}
