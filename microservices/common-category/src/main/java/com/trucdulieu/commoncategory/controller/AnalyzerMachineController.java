package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.AnalyzerMachineDto;
import com.trucdulieu.commoncategory.service.AnalyzerMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analyzer-machine")
@RequiredArgsConstructor
public class AnalyzerMachineController {
    private final AnalyzerMachineService analyzerMachineService;

    @PostMapping
    public ResponseEntity<?> creat(@RequestBody AnalyzerMachineDto req) {
        return ResponseEntity.ok(
                new ResponseObject(analyzerMachineService.creat(req))
        );
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AnalyzerMachineDto req) {
        return ResponseEntity.ok(
                new ResponseObject(analyzerMachineService.update(req))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ResponseObject(analyzerMachineService.delete(id))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ResponseObject(analyzerMachineService.getById(id))
        );
//        return new ResponseEntity<>(new ResponseObject(analyzerMachineService.getById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(
                new ResponseObject(analyzerMachineService.getAll())
        );
    }

    @GetMapping(Constant.FILTER)
    public ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String machineCode,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(analyzerMachineService.findWithFilter(id, name, machineCode, pageable))
        );
    }
}
