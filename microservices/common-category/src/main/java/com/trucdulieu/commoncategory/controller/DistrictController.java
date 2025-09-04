package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.DistrictDto;
import com.trucdulieu.commoncategory.service.interfaces.DistrictService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {
    @Autowired
    private final DistrictService districtService;
    @PostMapping
    public ResponseEntity<?> createDistrict(@RequestBody DistrictDto districtDto){
        return  ResponseEntity.ok().body((new ResponseObject(districtService.create(districtDto))));
//        return new ResponseEntity(districtService.create(districtDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllDistricts(){
        return ResponseEntity.ok(new ResponseObject(districtService.getDistrict()));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterDistricts(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DistrictDto> districts = districtService.filterDistricts(id, name, pageable);
        return ResponseEntity.ok(new ResponseObject(districts));
    }

    @GetMapping("/{districtId}")
    public ResponseEntity<?> getDistrictById(@PathVariable Long districtId){
        return ResponseEntity.ok(new ResponseObject(districtService.getById(districtId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDistrict(@RequestBody DistrictDto districtDto){
        return ResponseEntity.ok().body(new ResponseObject(districtService.update(districtDto)));
    }

    @DeleteMapping("/{districtId}")
    public ResponseEntity<?> deleteDistrict(@PathVariable Long districtId){
        return ResponseEntity.ok().body(new ResponseObject(districtService.delete(districtId)));
    }
}
