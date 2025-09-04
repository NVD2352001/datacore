package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.HTSSDto;
import com.trucdulieu.commoncategory.service.interfaces.HTSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/HealthcareTechnicalServicesStatus")
public class HTSSController {
    @Autowired
    private HTSSService htssService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok()
                .body(new ResponseObject(htssService.findAll()));
    }
    @PostMapping
    public ResponseEntity<?> createHTSS(@RequestBody HTSSDto htssDto){
        return  ResponseEntity.ok()
                .body(new ResponseObject(htssService.create(htssDto)));
    }
    @GetMapping(Constant.FILTER)
    public ResponseEntity<?> filterHTSS(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) int limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) int direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction ==0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok()
                .body(new ResponseObject(htssService.filterHTSS(id, name, code, description, pageable)));
    }
    @PutMapping("/{HTSSid}")
    public ResponseEntity<?> updateHTSS(@PathVariable Long HTSSid, @RequestBody HTSSDto htssDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(htssService.update(HTSSid, htssDto)));
    }
    @GetMapping("/{HTSSid}")
    public ResponseEntity<?> getById(@PathVariable Long HTSSid){
        return ResponseEntity.ok()
                .body(new ResponseObject(htssService.getById(HTSSid)));
    }
    @DeleteMapping("/{HTSSid}")
    public ResponseEntity<?> deleteHTSS(@PathVariable Long HTSSid){
        return ResponseEntity.ok()
                .body(new ResponseObject(htssService.delete(HTSSid)));
    }

}
