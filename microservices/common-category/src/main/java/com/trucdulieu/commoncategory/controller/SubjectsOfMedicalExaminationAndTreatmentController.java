package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.SubjectsOfMedicalExaminationAndTreatmentDto;
import com.trucdulieu.commoncategory.service.interfaces.SubjectsOfMedicalExaminationAndTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects_of_medical_examination_and_treatment")
public class SubjectsOfMedicalExaminationAndTreatmentController {
    @Autowired
    private SubjectsOfMedicalExaminationAndTreatmentService subjectsOfMedicalExaminationAndTreatmentService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(new ResponseObject(subjectsOfMedicalExaminationAndTreatmentService.findAll()));
    }
    @GetMapping("/{subjects_of_medical_examination_and_treatmentId}")
    public ResponseEntity<?> findById(@PathVariable Long subjects_of_medical_examination_and_treatmentId){
        return ResponseEntity.ok(new ResponseObject(subjectsOfMedicalExaminationAndTreatmentService.findById(subjects_of_medical_examination_and_treatmentId)));
    }
    @PostMapping
    public ResponseEntity<?> creat(@RequestBody SubjectsOfMedicalExaminationAndTreatmentDto dto){
        return ResponseEntity.ok(new ResponseObject(subjectsOfMedicalExaminationAndTreatmentService.add(dto)));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody SubjectsOfMedicalExaminationAndTreatmentDto dto){
        return ResponseEntity.ok(new ResponseObject(subjectsOfMedicalExaminationAndTreatmentService.update(dto)));
    }
    @DeleteMapping("/{subjects_of_medical_examination_and_treatmentId}")
    public  ResponseEntity<?> delete(@PathVariable Long subjects_of_medical_examination_and_treatmentId){
        return  ResponseEntity.ok(new ResponseObject(subjectsOfMedicalExaminationAndTreatmentService.delete(subjects_of_medical_examination_and_treatmentId)));
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
                new ResponseObject(subjectsOfMedicalExaminationAndTreatmentService.findWithFilter(id, name, description, pageable)));
    }
}
