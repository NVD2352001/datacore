package com.trucdulieu.commoncategory.service.interfaces;
import com.trucdulieu.commoncategory.base.BaseService;
import com.trucdulieu.commoncategory.model.dto.JobTitlDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobTitlService extends BaseService<JobTitlDto> {
    Page<JobTitlDto> findWithFilter(Long id, String name, String description, Pageable paging);
}
