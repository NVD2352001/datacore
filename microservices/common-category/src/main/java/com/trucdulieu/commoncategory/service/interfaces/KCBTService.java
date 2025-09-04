package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.KCBTDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KCBTService {
    KCBTDto create(KCBTDto kcbtDto);

    List<KCBTDto> findAll();

    KCBTDto getById(Long id);

    boolean delete(Long id);

    KCBTDto update(Long KCBTid, KCBTDto kcbtDto);

    Page<KCBTDto> filterKCBT(Long id, String name, String description, Pageable pageable);
}
