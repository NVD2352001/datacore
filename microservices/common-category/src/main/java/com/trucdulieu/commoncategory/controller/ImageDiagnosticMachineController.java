package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.ImageDiagnosticMachineDto;
import com.trucdulieu.commoncategory.service.interfaces.ImageDiagnosticMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image_diagnostic_machine")
public class ImageDiagnosticMachineController {
    @Autowired
    private ImageDiagnosticMachineService imageDiagnosticMachineService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(new ResponseObject(imageDiagnosticMachineService.findAll()));
    }

    @GetMapping("/{idmId}")
    public ResponseEntity<?> findById(@PathVariable Long idmId) {
        return ResponseEntity.ok(new ResponseObject(imageDiagnosticMachineService.findById(idmId)));
    }

    @PostMapping
    public ResponseEntity<?> creat(@RequestBody ImageDiagnosticMachineDto dto) {
        return ResponseEntity.ok(new ResponseObject(imageDiagnosticMachineService.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ImageDiagnosticMachineDto dto) {
        return ResponseEntity.ok(new ResponseObject(imageDiagnosticMachineService.update(dto)));
    }

    @DeleteMapping("/{idmId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable long idmId) {
        return ResponseEntity.ok(new ResponseObject(imageDiagnosticMachineService.delete(idmId)));
    }

    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable paging = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(imageDiagnosticMachineService.findWithFilter(id, name, description, code, paging)));
    }
}
