package com.trucdulieu.commoncategory.service.impl;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.TestIndexConverter;
import com.trucdulieu.commoncategory.model.dto.TestIndexDto;
import com.trucdulieu.commoncategory.model.entity.TestIndex;
import com.trucdulieu.commoncategory.reporsitory.TestIndexRepository;
import com.trucdulieu.commoncategory.service.interfaces.TestIndexService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestIndexImpl implements TestIndexService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TestIndexRepository testIndexRepository;
    @Override
    public List<TestIndexDto> findAll() {
        return testIndexRepository.findAll().stream().map(TestIndexConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<TestIndexDto> findByPage(Pageable paging) {
        return testIndexRepository.findAll(paging).map(TestIndexConverter::convertDto);
    }

    @Override
    public Page<TestIndexDto> findByName(String name, Pageable paging) {
        return testIndexRepository.findByNameContainingIgnoreCase(name,paging).map(TestIndexConverter::convertDto);
    }

    @Override
    public TestIndexDto findById(Long id) {
        return testIndexRepository.findById(id).map(TestIndexConverter::convertDto).orElse(null);
    }

    @Override
    public TestIndexDto add(TestIndexDto unit) {
        if(unit.getId()!= null) throw new RuntimeException(Constant.USER_INPUT);
        return modelMapper.map(
                testIndexRepository.save(modelMapper.map(unit, TestIndex.class)),
                TestIndexDto.class
        );
    }

    @Override
    public TestIndexDto update(TestIndexDto unit) {
        if(unit.getId()== null) throw new RuntimeException(Constant.USER_INPUT);
        Optional<TestIndex> foundDis =testIndexRepository.findById(unit.getId());
        TestIndex updateTestIndex = foundDis.map(
                testindex -> TestIndexConverter.convertEntity(unit, testindex)
        ).orElseGet(() -> TestIndexConverter.convertEntity(unit));
        return modelMapper.map(testIndexRepository.save(updateTestIndex), TestIndexDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (testIndexRepository.existsById(id)) {
            testIndexRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<TestIndexDto> findWithFilter(Long id, String name, String description, Double referenceValue, Double unit, Pageable paging) {
        return testIndexRepository.findWithFilter(id,name,description,referenceValue,unit,paging).map(TestIndexConverter::convertDto);
    }
}
