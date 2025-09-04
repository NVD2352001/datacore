package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.SickBedDto;
import com.trucdulieu.commoncategory.service.interfaces.SickBedSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sick-bed")
public class SickBedController {
    @Autowired
    private SickBedSerivce sickBedSerivce;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
               new ResponseObject(sickBedSerivce.findAll()));
    }
    @GetMapping("/{sickBedId}")
    public ResponseEntity<?> findById(@PathVariable Long sickBedId){
        return ResponseEntity.ok(new ResponseObject(sickBedSerivce.findById(sickBedId)));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody SickBedDto dto){
        return ResponseEntity.ok().body(
                new ResponseObject(sickBedSerivce.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody SickBedDto dto){
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(sickBedSerivce.update(dto))));
    }
    @DeleteMapping("/{sickBedId}")
    public ResponseEntity<?> delete(@PathVariable Long sickBedId){
        return ResponseEntity.ok(new ResponseObject(sickBedSerivce.delete(sickBedId)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable pageable  = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return  ResponseEntity.ok(
                new ResponseObject(sickBedSerivce.findWithFilter(id, name, pageable)));
    }
}
