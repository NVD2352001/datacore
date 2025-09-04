package com.trucdulieu.commoncategory.service.impl;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.CareerConverter;
import com.trucdulieu.commoncategory.model.dto.CareerDto;
import com.trucdulieu.commoncategory.model.entity.Career;
import com.trucdulieu.commoncategory.reporsitory.CareerRepository;
import com.trucdulieu.commoncategory.service.interfaces.CareerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CareerIpml implements CareerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CareerRepository careerRepository;
    @Override
    public List<CareerDto> findAll() {
        return careerRepository.findAll().stream().map(CareerConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<CareerDto> findByPage(Pageable paging) {
        return careerRepository.findAll(paging).map(CareerConverter::convertDto);
    }

    @Override
    public Page<CareerDto> findByName(String name, Pageable paging) {
        return careerRepository.findByNameContainingIgnoreCase(name,paging).map(CareerConverter::convertDto);
    }

    @Override
    public CareerDto findById(Long id) {
        return careerRepository.findById(id).map(CareerConverter::convertDto).orElse(null);
    }

    @Override
    public CareerDto add(CareerDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
              careerRepository.save(modelMapper.map(unit, Career.class)),
                CareerDto.class
        );
    }

    @Override
    public CareerDto update(CareerDto unit) {
        if(unit.getId()== null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Career> foundDis =careerRepository.findById(unit.getId());
        Career updateCareer = foundDis.map(
                career -> CareerConverter.convertEntity(unit, career)
        ).orElseGet(() -> CareerConverter.convertEntity(unit));
        return modelMapper.map(careerRepository.save(updateCareer), CareerDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (careerRepository.existsById(id)) {
            careerRepository.deleteById(id);
        }
        return true;
    }
    @Override
    public Page<CareerDto> findWithFilter(Long id, String name, String description, Pageable paging) {
        return careerRepository.findWithFilter(id,name,description,paging).map(CareerConverter::convertDto);
    }
}
