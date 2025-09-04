package com.trucdulieu.commoncategory.service.impl;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.JobTitlConverter;
import com.trucdulieu.commoncategory.model.dto.JobTitlDto;
import com.trucdulieu.commoncategory.model.entity.JobTitl;
import com.trucdulieu.commoncategory.reporsitory.JobTileRepository;
import com.trucdulieu.commoncategory.service.interfaces.JobTitlService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobTitlIplmpl implements JobTitlService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JobTileRepository jobTileRepository;
    @Override
    public List<JobTitlDto> findAll() {
        return jobTileRepository.findAll().stream().map(JobTitlConverter::convertDto).toList();
    }

    @Override
    public Page<JobTitlDto> findByPage(Pageable paging) {
        return jobTileRepository.findAll(paging).map(JobTitlConverter::convertDto);
    }

    @Override
    public Page<JobTitlDto> findByName(String name, Pageable paging) {
        return jobTileRepository.findByNameContainingIgnoreCase(name,paging).map(JobTitlConverter::convertDto);
    }

    @Override
    public JobTitlDto findById(Long id) {
        return jobTileRepository.findById(id).map(JobTitlConverter::convertDto).orElse(null);
    }

    @Override
    public JobTitlDto add(JobTitlDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
                jobTileRepository.save(modelMapper.map(unit, JobTitl.class)),
                JobTitlDto.class
        );
    }

    @Override
    public JobTitlDto update(JobTitlDto unit) {
        if(unit.getId()== null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<JobTitl> foundDis =jobTileRepository.findById(unit.getId());
        JobTitl updateTitle = foundDis.map(
                title -> JobTitlConverter.convertEntity(unit, title)
        ).orElseGet(() -> JobTitlConverter.convertEntity(unit));
        return modelMapper.map(jobTileRepository.save(updateTitle), JobTitlDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (jobTileRepository.existsById(id)) {
           jobTileRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<JobTitlDto> findWithFilter(Long id, String name, String description, Pageable paging) {
        return jobTileRepository.findWithFilter(id,name,description,paging).map(JobTitlConverter::convertDto);
    }
}
