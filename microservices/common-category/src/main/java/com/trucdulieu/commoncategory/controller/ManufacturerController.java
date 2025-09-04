package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.ManufacturerDto;
import com.trucdulieu.commoncategory.service.interfaces.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
                new ResponseObject(manufacturerService.findAll()));
    }
    @GetMapping("/{manufacturerId}")
    public ResponseEntity<?> findById(@PathVariable Long manufacturerId){
        return ResponseEntity.ok(new ResponseObject(manufacturerService.findById(manufacturerId)));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ManufacturerDto dto){
        return ResponseEntity.ok().body(new
                ResponseObject(manufacturerService.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ManufacturerDto dto) {
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(manufacturerService.update(dto))));
    }
    @DeleteMapping("/{manufacturerId}")
    public  ResponseEntity<?> delete(@PathVariable Long manufacturerId){
        return  ResponseEntity.ok(new ResponseObject(manufacturerService.delete(manufacturerId)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String companyName,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable pageable  = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return  ResponseEntity.ok(
                new ResponseObject(manufacturerService.findWithFilter(id, name, companyName,description,pageable)));
    }
}
