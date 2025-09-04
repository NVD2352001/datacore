package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trucdulieu.commoncategory.model.dto.WardDto;
import com.trucdulieu.commoncategory.service.interfaces.WardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wards")
@RequiredArgsConstructor
public class WardController{

    @Autowired
    WardService wardService;

    @PostMapping
    public ResponseEntity<?> createWard(@RequestBody WardDto wardDto) {
        return ResponseEntity.ok()
                .body(wardService.create(wardDto));
    }
    @PutMapping("/{wardId}")
    public ResponseEntity<?> updateWard(@PathVariable Long wardId, @RequestBody WardDto wardDto) {
        return ResponseEntity.ok()
                .body(new ResponseObject(wardService.update(wardId, wardDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllWards() {
        return ResponseEntity.ok()
                .body(new ResponseObject(wardService.getWards()));
    }

    @GetMapping(Constant.FILTER)
    public ResponseEntity<?> filterWards(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) int direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) int limit) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok()
                .body(new ResponseObject(wardService.filterWards(id, name, description, pageable)));
    }
    @DeleteMapping("/{wardId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long wardId){
        return ResponseEntity.ok()
                .body(new ResponseObject(wardService.delete(wardId)));
    }

    @GetMapping("/{wardId}")
    public ResponseEntity<?> getWardById(@PathVariable Long wardId) {
       return ResponseEntity.ok()
               .body(new ResponseObject(wardService.getById(wardId)));
    }
}