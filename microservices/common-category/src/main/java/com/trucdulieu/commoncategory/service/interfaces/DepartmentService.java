package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.DepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    public DepartmentDto getById(Long id);
    public DepartmentDto create(DepartmentDto departmentDto);
    public List<DepartmentDto> getDepartments();

    public Page<DepartmentDto> filterDepartments(Long id, String name, Pageable pageable);
    public DepartmentDto update(DepartmentDto dto);

    public Boolean delete(Long id);
}
