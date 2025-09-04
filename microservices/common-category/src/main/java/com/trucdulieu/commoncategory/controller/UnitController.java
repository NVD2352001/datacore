package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.UnitDto;
import com.trucdulieu.commoncategory.service.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(new ResponseObject(unitService.findAll()));
    }
    @GetMapping("/{unitId}")
    public ResponseEntity<?> findById(@PathVariable Long unitId){
        return ResponseEntity.ok(new ResponseObject(unitService.findById(unitId)));
    }
    @PostMapping
    public ResponseEntity<?> creat(@RequestBody UnitDto dto){
        return ResponseEntity.ok(new ResponseObject(unitService.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UnitDto dto){
        return ResponseEntity.ok(new ResponseObject(unitService.update(dto)));
    }
    @DeleteMapping("/{unitId}")
    public  ResponseEntity<?> delete(@PathVariable Long unitId){
        return  ResponseEntity.ok(new ResponseObject(unitService.delete(unitId)));
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
                new ResponseObject(unitService.findWithFilter(id, name, description, pageable)));
    }
}
