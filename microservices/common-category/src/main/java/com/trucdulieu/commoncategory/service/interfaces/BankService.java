package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.BankDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService extends BaseService<BankDto> {
    Page<BankDto> findWithFilter(Long id,String name,String description,String code,String bin,String shortName,String swiftCode, Pageable paging);
}
