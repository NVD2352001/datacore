package com.trucdulieu.commoncategory.service.interfaces;

import com.trucdulieu.commoncategory.model.dto.GenderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenderService {
    Page<GenderDto> getByName(String name, Pageable pageable);

    GenderDto getByGenderId(Long id);
    GenderDto createGender(GenderDto genderDto);
    List<GenderDto> getGenders();
    GenderDto updateGender(GenderDto Dto);
    void deleteGender(Long id);
    Page<GenderDto> filterGender(Long id, String name, String description,Pageable pageable);
}
