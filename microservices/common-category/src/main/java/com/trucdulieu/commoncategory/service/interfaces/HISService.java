package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.HISDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HISService {

    HISDto create(HISDto hisDto);

    HISDto update(Long hisId, HISDto hisDto);

    Page<HISDto> filterHISs(Long id, String name, Pageable pageable);

    HISDto getById(Long hisId);

    boolean delete(Long id);

    List<HISDto> findAll();
}
