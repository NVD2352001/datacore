package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;

import com.trucdulieu.commoncategory.model.dto.MedicalRouteDto;
import com.trucdulieu.commoncategory.service.interfaces.MedicalRouteService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MedicalRoute")
public class MedicalRouteController {
    @Autowired
    private MedicalRouteService routeService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(new ResponseObject(routeService.findAll()));
    }
    @PostMapping
    public ResponseEntity<?> createMR(@RequestBody MedicalRouteDto dto){
        return ResponseEntity.ok().body(new ResponseObject(routeService.create(dto)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> filterMR(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) int limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) int direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ){
       Pageable pageable = PageRequest.of(page, limit, Sort.by(direction == 0? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
       return ResponseEntity.ok(new ResponseObject(routeService.filterMR(id, name, description, pageable)));
    }
    @PutMapping("/{RouteId}")
    public ResponseEntity<?> updateMR(@PathVariable Long RouteId, @RequestBody MedicalRouteDto mr){
        return ResponseEntity.ok().body(new ResponseObject(routeService.update(RouteId,mr)));
    }
    @GetMapping("/{RouteId}")
    public ResponseEntity<?> getById(@PathVariable Long RouteId){
        return ResponseEntity.ok().body(new ResponseObject(routeService.getById(RouteId)));
    }
    @DeleteMapping("/{RouteId}")
    public ResponseEntity<?> deleteRoute(@PathVariable Long RouteId){
        return ResponseEntity.ok().body(new ResponseObject(routeService.getById(RouteId)));
    }
}
