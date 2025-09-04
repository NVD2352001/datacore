package com.trucdulieu.commoncategory.service.impl;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.PositionConverter;
import com.trucdulieu.commoncategory.model.dto.PositionDto;
import com.trucdulieu.commoncategory.model.entity.Position;
import com.trucdulieu.commoncategory.reporsitory.PositionRepository;
import com.trucdulieu.commoncategory.service.interfaces.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<PositionDto> findAll() {
        return positionRepository.findAll().stream().map(PositionConverter::convertDto).toList();
    }

    @Override
    public Page<PositionDto> findByPage(Pageable paging) {
        return positionRepository.findAll(paging).map(PositionConverter::convertDto);
    }

    @Override
    public Page<PositionDto> findByName(String name, Pageable paging) {
        return positionRepository.findByNameContainingIgnoreCase(name,paging).map(PositionConverter::convertDto);
    }

    @Override
    public PositionDto findById(Long id) {
        return positionRepository.findById(id).map(PositionConverter::convertDto).orElse(null);
    }

    @Override
    public PositionDto add(PositionDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
                positionRepository.save(modelMapper.map(unit, Position.class)),
                PositionDto.class
        );
    }

    @Override
    public Boolean delete(Long id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<PositionDto> findWithFilter(Long id, String name, String description, Pageable paging) {
        return positionRepository.findWithFilter(id,name,description,paging).map(PositionConverter::convertDto);
    }

    @Override
    public PositionDto update(PositionDto unit) {
        if(unit.getId()== null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<Position> foundDis =positionRepository.findById(unit.getId());
        Position updateTitle = foundDis.map(
                title -> PositionConverter.convertEntity(unit, title)
        ).orElseGet(() -> PositionConverter.convertEntity(unit));
        return modelMapper.map(positionRepository.save(updateTitle), PositionDto.class);
    }
}
