package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.TestCatalogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestCatalogService extends BaseService<TestCatalogDto> {
    Page<TestCatalogDto> filterTestCatalog(Long id, String code, String index, String name, Pageable pageable);
}
