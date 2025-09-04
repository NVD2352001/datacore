package com.trucdulieu.commoncategory.service.interfaces;
import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.CareerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface CareerService extends BaseService<CareerDto> {
    Page<CareerDto> findWithFilter(Long id, String name, String description,Pageable paging);
}
