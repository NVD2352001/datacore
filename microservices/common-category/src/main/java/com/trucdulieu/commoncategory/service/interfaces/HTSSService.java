package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.HTSSDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HTSSService {
    HTSSDto create(HTSSDto htssDto);

    List<HTSSDto> findAll();

    HTSSDto getById(Long id);

    boolean delete(Long id);

    HTSSDto update(Long HTSSid, HTSSDto htssDto);

    Page<HTSSDto> filterHTSS(Long id, String name, String code, String description, Pageable pageable);
}
