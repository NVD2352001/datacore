package com.trucdulieu.commoncategory.service;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.CityMapper;
import com.trucdulieu.commoncategory.model.entity.City;
import com.trucdulieu.commoncategory.reporsitory.CityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trucdulieu.commoncategory.model.dto.CityCreationDto;
import com.trucdulieu.commoncategory.model.dto.CityDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    public CityDto creatCity(CityCreationDto req) {
        if(req.getId() != null)
            throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(cityRepository.save(modelMapper.map(req, City.class)), CityDto.class);
    }

    public CityDto updateCity(CityDto req) {
        if(req.getId() == null)
            throw new RuntimeException(Constant.USER_INPUT);
        Optional<City> cityOptional = cityRepository.findById(req.getId());
        City city = cityOptional.map(output -> CityMapper.forUpdate(output, req))
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
        return modelMapper.map(cityRepository.save(city), CityDto.class);
    }

    public Page<CityDto> getAllCity(Pageable pageable) {
        return cityRepository.findAll(pageable).map(CityMapper::toDTO);
    }

    public CityDto getById(Long id) {
        return cityRepository.findById(id)
                .map(CityMapper::toDTO)
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
    }

    public Boolean deleteCity(Long id) {
        if(!cityRepository.existsById(id))
            throw new RuntimeException(Constant.NOT_FOUND);
        cityRepository.deleteById(id);
//        return Constant.SUCCESS;
        return true;
    }

    public Page<CityDto> findWithFilter(Long id, String name, String regions, Pageable pageable) {

        return cityRepository.findWithFilter(id, name, regions, pageable).map(CityMapper::toDTO);
    }
}
