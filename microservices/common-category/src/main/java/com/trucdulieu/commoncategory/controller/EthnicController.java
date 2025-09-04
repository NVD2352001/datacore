package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.EthnicDto;
import com.trucdulieu.commoncategory.service.interfaces.EthnicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ethnic")
@RequiredArgsConstructor
public class EthnicController {
    @Autowired
    private EthnicService ethnicService;
    @PostMapping
    public ResponseEntity<?> createEthnic(@RequestBody EthnicDto ethnicDto){
        return ResponseEntity.ok(new ResponseObject(ethnicService.add(ethnicDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllEthnic(){
        return ResponseEntity.ok(new ResponseObject(ethnicService.findAll()));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterEthnic(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<EthnicDto> ethnicDtos = ethnicService.findWithFilter(id, name, pageable);
        return ResponseEntity.ok(new ResponseObject(ethnicDtos));
    }

    @GetMapping("/{ethnicId}")
    public ResponseEntity<?> getEthnicById(@PathVariable Long ethnicId){
        return ResponseEntity.ok(new ResponseObject(ethnicService.findById(ethnicId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEthnic(@RequestBody EthnicDto ethnicDto){
        return ResponseEntity.ok().body(new ResponseObject(ethnicService.update(ethnicDto)));
    }

    @DeleteMapping("/{ethnicId}")
    public ResponseEntity<?> deleteEthnic(@PathVariable Long ethnicId){
        return ResponseEntity.ok().body(new ResponseObject(ethnicService.delete(ethnicId)));
    }
}
