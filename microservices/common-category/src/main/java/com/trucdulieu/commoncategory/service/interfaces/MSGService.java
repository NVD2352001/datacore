package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.MSGDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MSGService {
    MSGDto create(MSGDto msgDto);

    MSGDto update(Long msgId, MSGDto msgDto);

    List<MSGDto> getMSG();


    Page<MSGDto> filterMSG(Long id, String name, String code, String description, Pageable pageable);


    MSGDto getById(Long id);

    boolean delete(Long id);
}
