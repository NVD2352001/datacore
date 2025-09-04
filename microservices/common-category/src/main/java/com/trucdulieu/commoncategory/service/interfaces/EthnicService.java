package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.EthnicDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EthnicService extends BaseService<EthnicDto> {
    Page<EthnicDto> findWithFilter(Long id, String name, Pageable paging);
}
