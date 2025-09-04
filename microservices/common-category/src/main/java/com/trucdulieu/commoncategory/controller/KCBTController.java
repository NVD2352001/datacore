package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.KCBTDto;
import com.trucdulieu.commoncategory.service.interfaces.KCBTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/KhamChuaBenh")
public class KCBTController {
    @Autowired
    private KCBTService kcbtService;

    @GetMapping
    public ResponseEntity<?> findALL(){
        return ResponseEntity.ok()
                .body(new ResponseObject(kcbtService.findAll()));

    }
    @PostMapping
    public ResponseEntity<?> createKBCT(@RequestBody KCBTDto kcbtDto){
        return ResponseEntity.ok().body(new ResponseObject(kcbtService.create(kcbtDto)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> filterKCBT(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) int limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) int direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ){
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction ==0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok().body(new ResponseObject(kcbtService.filterKCBT(id, name, description, pageable)));
    }
    @PutMapping("/{KCBTid}")
    public ResponseEntity<?> updateKCBT(@PathVariable Long KCBTid, @RequestBody KCBTDto kcbtDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(kcbtService.update(KCBTid, kcbtDto)));
    }
    @GetMapping("/{KCBTid}")
    public ResponseEntity<?> getById(@PathVariable Long KCBTid){
        return ResponseEntity.ok()
                .body(new ResponseObject(kcbtService.getById(KCBTid)));
    }
    @DeleteMapping("/{KCBTid}")
    public ResponseEntity<?> deleteKCBT(@PathVariable Long KCBTid){
        return ResponseEntity.ok()
                .body(new ResponseObject(kcbtService.delete(KCBTid)));
    }
}
