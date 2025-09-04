package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.TechnicalServiceGroupDto;
import com.trucdulieu.commoncategory.service.interfaces.TechnicalServiceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technical_service_group")
public class TechnicalServiceGroupController {
    @Autowired
    private TechnicalServiceGroupService technicalServiceGroupService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(new ResponseObject(technicalServiceGroupService.findAll()));
    }
    @GetMapping("/{technical_service_groupId}")
    public ResponseEntity<?> findById(@PathVariable Long technical_service_groupId){
        return ResponseEntity.ok(new ResponseObject(technicalServiceGroupService.findById(technical_service_groupId)));
    }
    @PostMapping
    public ResponseEntity<?> creat(@RequestBody TechnicalServiceGroupDto dto){
        return ResponseEntity.ok(new ResponseObject(technicalServiceGroupService.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody TechnicalServiceGroupDto dto){
        return ResponseEntity.ok(new ResponseObject(technicalServiceGroupService.update(dto)));
    }
    @DeleteMapping("/{technical_service_groupId}")
    public  ResponseEntity<?> delete(@PathVariable Long technical_service_groupId){
        return  ResponseEntity.ok(new ResponseObject(technicalServiceGroupService.delete(technical_service_groupId)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFiler(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField){
        Pageable pageable = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(technicalServiceGroupService.findWithFilter(id, name, description, pageable)));
    }
}
