package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.TestCatalogDto;
import com.trucdulieu.commoncategory.service.interfaces.TestCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test_catalog")
@RequiredArgsConstructor
public class TestCatalogController {
    @Autowired
    private TestCatalogService testCatalogService;

    @PostMapping
    public ResponseEntity<?> createTestCatalog(@RequestBody TestCatalogDto testCatalogDto){
        return ResponseEntity.ok(new ResponseObject(testCatalogService.add(testCatalogDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCatalog(){
        return ResponseEntity.ok(new ResponseObject(testCatalogService.findAll()));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterTestCatalog(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "index", required = false) String index,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<TestCatalogDto> testCatalogDtos = testCatalogService.filterTestCatalog(id,code,index,name,pageable);
        return ResponseEntity.ok(new ResponseObject(testCatalogDtos));
    }

    @GetMapping("/{testCatalogId}")
    public ResponseEntity<?> getTestCatalogById(@PathVariable Long testCatalogId){
        return ResponseEntity.ok(new ResponseObject(testCatalogService.findById(testCatalogId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTestCatalog(@RequestBody TestCatalogDto testCatalogDto){
        return ResponseEntity.ok().body(new ResponseObject(testCatalogService.update(testCatalogDto)));
    }

    @DeleteMapping("/{testCatalogId}")
    public ResponseEntity<?> deleteTestCatalog(@PathVariable Long testCatalogId){
        return ResponseEntity.ok().body(new ResponseObject(testCatalogService.delete(testCatalogId)));
    }
}
