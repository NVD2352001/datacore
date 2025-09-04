package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.PositionDto;
import com.trucdulieu.commoncategory.service.interfaces.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @GetMapping
    public ResponseEntity<?> findAll(
    ) {
        return ResponseEntity.ok(
                new ResponseObject(positionService.findAll()));
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<?> findById(@PathVariable Long positionId) {
        return ResponseEntity.ok(new ResponseObject(positionService.findById(positionId)));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody PositionDto dto) {
        return ResponseEntity.ok().body(
                new ResponseObject(positionService.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PositionDto dto) {
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(positionService.update(dto))));
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable long positionId) {
        return ResponseEntity.ok(new ResponseObject(positionService.delete(positionId)));
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
                new ResponseObject(positionService.findWithFilter(id, name, description, paging)));
    }
}
