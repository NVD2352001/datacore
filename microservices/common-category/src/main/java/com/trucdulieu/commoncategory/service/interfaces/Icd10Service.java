package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.Icd10Dto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Icd10Service extends BaseService<Icd10Dto> {
    Page<Icd10Dto> findWithFilter(Long id, String name, String code,String chapter, String group, Pageable pageable);

}
