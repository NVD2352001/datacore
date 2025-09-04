package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.model.converter.EthnicConverter;
import com.trucdulieu.commoncategory.model.dto.EthnicDto;
import com.trucdulieu.commoncategory.model.entity.Ethnic;
import com.trucdulieu.commoncategory.reporsitory.EthnicRepository;
import com.trucdulieu.commoncategory.service.interfaces.EthnicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

public class EthnicServiceImpl implements EthnicService {
    @Autowired
    private EthnicRepository ethnicRepository;
    @Override
    public List<EthnicDto> findAll() {
        List<Ethnic> ethnicDtoList = ethnicRepository.findAll();
        return ethnicDtoList.stream().map(EthnicConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<EthnicDto> findByPage(Pageable paging) {
        return ethnicRepository.findAll(paging).map(EthnicConverter::convertDto);
    }

    @Override
    public Page<EthnicDto> findByName(String name, Pageable paging) {
        return null;
    }

    @Override
    public EthnicDto findById(Long id) {
        return ethnicRepository.findById(id).map(EthnicConverter::convertDto).orElse(null);
    }

    @Override
    public EthnicDto add(EthnicDto unit) {
        return EthnicConverter.convertDto(ethnicRepository.save(EthnicConverter.convertEntity(unit)));
    }

    @Override
    public EthnicDto update(EthnicDto unit) {
        if(unit.getId() == null) throw new RuntimeException("Update with null ID");
        Ethnic item = ethnicRepository.findById(unit.getId()).orElse(null);
        if(item != null){
            return EthnicConverter.convertDto(ethnicRepository.save(EthnicConverter.convertEntity(unit, item)));
        }
        else{
            throw new RuntimeException("Update with not existed");
        }
    }

    @Override
    public Boolean delete(Long id) {
        if(ethnicRepository.existsById(id)){
            ethnicRepository.deleteById(id);

        }
        return true;
    }

    @Override
    public Page<EthnicDto> findWithFilter(Long id, String name, Pageable paging) {
        return ethnicRepository.findByEthnicIdAndNameWithPagination(id, name, paging).map(EthnicConverter::convertDto);
    }
}
