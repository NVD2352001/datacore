package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.MedicalRecordTemplateDto;
import com.trucdulieu.commoncategory.service.interfaces.MedicalRecordTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical_record_template")
public class MedicalRecordTemplateController {
    @Autowired
    private MedicalRecordTemplateService medicalRecordTemplateService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                new ResponseObject(medicalRecordTemplateService.findAll()));
    }
    @GetMapping("/{medicalRecordTemplateId}")
    public ResponseEntity<?> findById(@PathVariable Long medicalRecordTemplateId){
        return ResponseEntity.ok(new ResponseObject(medicalRecordTemplateService.findById(medicalRecordTemplateId)));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MedicalRecordTemplateDto dto){
        return ResponseEntity.ok().body(new ResponseObject(medicalRecordTemplateService.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MedicalRecordTemplateDto dto){
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(medicalRecordTemplateService.update(dto))));
    }
    @DeleteMapping("/{medicalRecordTemplateId}")
    public ResponseEntity<?> delete(@PathVariable Long medicalRecordTemplateId){
        return ResponseEntity.ok(new ResponseObject(medicalRecordTemplateService.delete(medicalRecordTemplateId)));
    }
    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField){
        Pageable pageable = PageRequest.of(
                page,limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(medicalRecordTemplateService.findWithFilter(id,name,description,pageable)));
    }

}
