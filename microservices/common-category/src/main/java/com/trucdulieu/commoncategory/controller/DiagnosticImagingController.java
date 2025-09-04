package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.DiagnosticImagingDto;
import com.trucdulieu.commoncategory.service.interfaces.DiagnosticImagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diagnoimaging")
public class DiagnosticImagingController {
    @Autowired
    private DiagnosticImagingService diagnosticImagingService;
    @GetMapping
    public ResponseEntity<?> findAll(
    ) {
        return ResponseEntity.ok(
                new ResponseObject(diagnosticImagingService.findAll()));
    }

    @GetMapping("/{diagnoId}")
    public ResponseEntity<?> findById(@PathVariable Long diagnoId) {
        return ResponseEntity.ok(new ResponseObject(diagnosticImagingService.findById(diagnoId)));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody DiagnosticImagingDto dto) {
        return ResponseEntity.ok().body(
                new ResponseObject(diagnosticImagingService.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody DiagnosticImagingDto dto) {
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(diagnosticImagingService.update(dto))));
    }

    @DeleteMapping("/{diagnoId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable long diagnoId) {
        return ResponseEntity.ok(new ResponseObject(diagnosticImagingService.delete(diagnoId)));
    }

    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable paging = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(diagnosticImagingService.findWithFilter(id, name, description, paging)));
    }
}
