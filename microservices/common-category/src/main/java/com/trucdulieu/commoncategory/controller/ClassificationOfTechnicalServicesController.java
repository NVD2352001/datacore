package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.ClassificationOfTechnicalServicesDto;
import com.trucdulieu.commoncategory.service.ClassificationOfTechnicalServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classification-of-technical-services")
public class ClassificationOfTechnicalServicesController {
    private final ClassificationOfTechnicalServicesService technicalServicesService;

    @PostMapping
    public ResponseEntity<?> creat(@RequestBody ClassificationOfTechnicalServicesDto req) {
        return ResponseEntity.ok(
                new ResponseObject(technicalServicesService.creat(req))
        );
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ClassificationOfTechnicalServicesDto req) {
        return ResponseEntity.ok(
                new ResponseObject(technicalServicesService.update(req))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ResponseObject(technicalServicesService.delete(id))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ResponseObject(technicalServicesService.getById(id))
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(
                new ResponseObject(technicalServicesService.getAll())
        );
    }

    @GetMapping(Constant.FILTER)
    public ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(technicalServicesService.findWithFilter(id, name, code, pageable))
        );
    }
}
