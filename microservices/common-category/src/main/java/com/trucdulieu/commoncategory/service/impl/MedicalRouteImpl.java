package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.MedicalRouteConverter;
import com.trucdulieu.commoncategory.model.dto.MedicalRouteDto;
import com.trucdulieu.commoncategory.model.entity.MedicalRoute;
import com.trucdulieu.commoncategory.reporsitory.MedicalRouteRepo;
import com.trucdulieu.commoncategory.service.interfaces.MedicalRouteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class MedicalRouteImpl implements MedicalRouteService {
    private final MedicalRouteRepo mrRepo;
    private final ModelMapper mapper;

    @Override
    public MedicalRouteDto create (MedicalRouteDto mr){
        if (mr.getId() != null) throw new RuntimeException(Constant.USER_INPUT);
        return mapper.map(
                mrRepo.save(mapper.map(mr, MedicalRoute.class)),
                MedicalRouteDto.class);
    }
    @Override
    public List<MedicalRouteDto> findAll(){
        return mrRepo.findAll().stream().map(MedicalRouteConverter::convertDto)
                .collect(Collectors.toList());
    }
    @Override
    public MedicalRouteDto getById(Long id) {
        return mrRepo.findById(id).map(MedicalRouteConverter::convertDto).orElse(null);
    }
    @Override
    public MedicalRouteDto update(Long RouteId, MedicalRouteDto mr){
        if (mr.getId() != null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<MedicalRoute> routeOptional = mrRepo.findById(RouteId);
        MedicalRoute updateRoute = routeOptional.map(
                medicalRoute -> MedicalRouteConverter.convertEntity(mr, medicalRoute)
        ).orElseGet(() -> MedicalRouteConverter.convertEntity(mr));
        return mapper.map(mrRepo.save(updateRoute),MedicalRouteDto.class);
    }
    @Override
    public boolean delete(Long id){
        if (mrRepo.existsById(id)){
            mrRepo.deleteById(id);
        }
        return true;
    }
    @Override
    public Page<MedicalRouteDto> filterMR(Long id, String name, String description, Pageable pageable){
        return mrRepo.findIdNameDesc(id, name, description, pageable).map(MedicalRouteConverter::convertDto);
    }

}
