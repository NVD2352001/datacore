package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.ManufacturingCountryDto;
import com.trucdulieu.commoncategory.service.interfaces.ManufacturingCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacturing_country")
public class ManufacturingCountryController {
    @Autowired
    private ManufacturingCountryService manufacturingCountryService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(new ResponseObject(manufacturingCountryService.findAll()));
    }
    @GetMapping("/{manufacturing_countryId}")
    public ResponseEntity<?> findById(@PathVariable Long manufacturing_countryId){
        return ResponseEntity.ok(new ResponseObject(manufacturingCountryService.findById(manufacturing_countryId)));
    }
    @PostMapping
    public ResponseEntity<?> creat(@RequestBody ManufacturingCountryDto dto){
        return ResponseEntity.ok(new ResponseObject(manufacturingCountryService.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ManufacturingCountryDto dto){
        return ResponseEntity.ok(new ResponseObject(manufacturingCountryService.update(dto)));
    }
    @DeleteMapping("/{manufacturing_countryId}")
    public  ResponseEntity<?> delete(@PathVariable Long manufacturing_countryId){
        return  ResponseEntity.ok(new ResponseObject(manufacturingCountryService.delete(manufacturing_countryId)));
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
                new ResponseObject(manufacturingCountryService.findWithFilter(id, name, description, pageable)));
    }

}
