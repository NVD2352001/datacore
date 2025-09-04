package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.DepartmentConverter;
import com.trucdulieu.commoncategory.model.dto.DepartmentDto;
import com.trucdulieu.commoncategory.model.entity.Department;
import com.trucdulieu.commoncategory.reporsitory.DepartmentRepository;
import com.trucdulieu.commoncategory.service.interfaces.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto getById(Long id) {
        return departmentRepository.findById(id).map(DepartmentConverter::convertDto).orElse(null);
    }

    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        return DepartmentConverter.convertDto(departmentRepository.save(DepartmentConverter.convertEntity(departmentDto))) ;
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentConverter::convertDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Page<DepartmentDto> filterDepartments(Long id, String name, Pageable pageable) {
        return departmentRepository.findWithFilter(id, name, pageable).map(DepartmentConverter::convertDto);
    }

    @Override
    public DepartmentDto update(DepartmentDto dto) {
        if(dto.getId() == null)
            throw new RuntimeException(Constant.USER_INPUT);
        Department item = departmentRepository.findById(dto.getId()).orElse(null);
        if(item == null){
            throw new RuntimeException(Constant.NOT_FOUND);
        }
        else {
            item = DepartmentConverter.convertEntity(dto,item);
            return DepartmentConverter.convertDto(departmentRepository.save(item));
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            departmentRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(Constant.NOT_FOUND);
        } catch (Exception e) {
            throw new RuntimeException(Constant.ERROR);
        }
    }
}
