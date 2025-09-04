package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.Icd10Dto;
import com.trucdulieu.commoncategory.service.interfaces.Icd10Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/icd_10s")
@RequiredArgsConstructor
public class Icd10Controller {
    @Autowired
    private Icd10Service icd10Service;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(new ResponseObject(icd10Service.findAll()));
    }
    @GetMapping("/{icd_10Id}")
    public ResponseEntity<?> findById(@PathVariable Long icd_10Id){
        return ResponseEntity.ok(new ResponseObject(icd10Service.findById(icd_10Id)));
    }
    @PostMapping
    public ResponseEntity<?> creat(@RequestBody Icd10Dto dto){
        return ResponseEntity.ok(new ResponseObject(icd10Service.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Icd10Dto dto){
        return ResponseEntity.ok(new ResponseObject(icd10Service.update(dto)));
    }
    @DeleteMapping("/{icd_10Id}")
    public  ResponseEntity<?> delete(@PathVariable Long icd_10Id){
        return  ResponseEntity.ok(new ResponseObject(icd10Service.delete(icd_10Id)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFiler(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(required = false, defaultValue = "") String chapter,
            @RequestParam(required = false, defaultValue = "") String group,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField){
        Pageable pageable = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(icd10Service.findWithFilter(id, name, code, chapter,group,pageable)));
    }
}
