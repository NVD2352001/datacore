package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.TestIndexDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestIndexService extends BaseService<TestIndexDto> {
    Page<TestIndexDto> findWithFilter(Long id, String name, String description, Double referenceValue, Double unit, Pageable paging);
}
