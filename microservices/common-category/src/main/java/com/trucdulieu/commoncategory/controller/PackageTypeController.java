package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.PackageTypeDto;
import com.trucdulieu.commoncategory.service.interfaces.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/package_type")
public class PackageTypeController {
    @Autowired
    private PackageTypeService packageTypeService;

    @PostMapping
    public ResponseEntity<?> createPackageType(@RequestBody PackageTypeDto packageTypeDto){
        return ResponseEntity.ok().body(new ResponseObject(packageTypeService.create(packageTypeDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllPackageTypes(){
        return ResponseEntity.ok().body(new ResponseObject(packageTypeService.getPackageType()));
    }

    @GetMapping("/{packageTypeId}")
    public ResponseEntity<?> getPackageTypeById(@PathVariable Long packageTypeId){
        return ResponseEntity.ok().body(new ResponseObject(packageTypeService.getById(packageTypeId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePackageType(@RequestBody PackageTypeDto packageTypeDto){
        return ResponseEntity.ok().body(new ResponseObject(packageTypeService.update(packageTypeDto)));
    }

    @DeleteMapping("/{packageTypeId}")
    public ResponseEntity<?> deletePackageType(@PathVariable Long packageTypeId){
        return ResponseEntity.ok().body(new ResponseObject(packageTypeService.delete(packageTypeId)));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterPackageTypes(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "page", defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(value = "size", defaultValue = Constant.LIMIT_DEFAULT) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(new ResponseObject(packageTypeService.filterPackageTypes(id, name, code, pageable)));
    }
}
