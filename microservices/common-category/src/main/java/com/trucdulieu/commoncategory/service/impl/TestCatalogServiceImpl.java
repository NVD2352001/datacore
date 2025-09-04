package com.trucdulieu.commoncategory.service.impl;

import com.trucdulieu.commoncategory.model.converter.TestCatalogConverter;
import com.trucdulieu.commoncategory.model.dto.TestCatalogDto;
import com.trucdulieu.commoncategory.model.entity.TestCatalog;
import com.trucdulieu.commoncategory.reporsitory.TestCatalogRepository;
import com.trucdulieu.commoncategory.service.interfaces.TestCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class TestCatalogServiceImpl implements TestCatalogService {
    @Autowired
    private TestCatalogRepository testCatalogRepository;
    @Override
    public List<TestCatalogDto> findAll() {
        List<TestCatalog> testCatalogList = testCatalogRepository.findAll();
        return testCatalogList.stream().map(TestCatalogConverter::convertDto).collect(Collectors.toList());
    }

    @Override
    public Page<TestCatalogDto> findByPage(Pageable paging) {
        return testCatalogRepository.findAll(paging).map(TestCatalogConverter::convertDto);
    }

    @Override
    public Page<TestCatalogDto> findByName(String name, Pageable paging) {
        return testCatalogRepository.filterTestCatalog(null,null,null,name,paging).map(TestCatalogConverter::convertDto);
    }

    @Override
    public TestCatalogDto findById(Long id) {
        return testCatalogRepository.findById(id).map(TestCatalogConverter::convertDto).orElse(null);
    }

    @Override
    public TestCatalogDto add(TestCatalogDto unit) {
        return TestCatalogConverter.convertDto(testCatalogRepository.save(TestCatalogConverter.convertEntity(unit)));
    }

    @Override
    public TestCatalogDto update(TestCatalogDto unit) {
        if(unit.getId() == null) throw new RuntimeException("Update with null ID");
        TestCatalog item = testCatalogRepository.findById(unit.getId()).orElse(null);
        if(item != null){
            return TestCatalogConverter.convertDto(testCatalogRepository.save(TestCatalogConverter.convertEntity(unit, item)));
        }
        else{
            throw new RuntimeException("Update with not existed");
        }
    }

    @Override
    public Boolean delete(Long id) {
        if(testCatalogRepository.existsById(id)){
            testCatalogRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public Page<TestCatalogDto> filterTestCatalog(Long id, String code, String index, String name, Pageable pageable) {
        return testCatalogRepository.filterTestCatalog(id, code, index, name, pageable).map(TestCatalogConverter::convertDto);
    }
}
