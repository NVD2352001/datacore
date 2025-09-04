package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.ClinicDto;
import com.trucdulieu.commoncategory.service.interfaces.ClinicSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private ClinicSerivce clinicSerivce;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                new ResponseObject(clinicSerivce.findAll()));
    }

    @GetMapping("/{clinicId}")
    public ResponseEntity<?> findById(@PathVariable Long clinicId){
        return ResponseEntity.ok(new ResponseObject(clinicSerivce.findById(clinicId)));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ClinicDto dto){
        return ResponseEntity.ok().body(new
                ResponseObject(clinicSerivce.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ClinicDto dto){
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(clinicSerivce.update(dto))));
    }

    @DeleteMapping("/{clinicId}")
    public  ResponseEntity<?> delete(@PathVariable Long clinicId){
        return  ResponseEntity.ok(new ResponseObject(clinicSerivce.delete(clinicId)));
    }

    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable paing  = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return  ResponseEntity.ok(
                new ResponseObject(clinicSerivce.findWithFilter(id, name, paing)));
    }

}
