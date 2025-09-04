package com.trucdulieu.commoncategory.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.SexDto;

public interface SexSevice extends BaseService<SexDto> {

    public Page<SexDto> findByName(Pageable paging);
}
