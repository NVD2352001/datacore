package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.CareerDto;
import com.trucdulieu.commoncategory.service.interfaces.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/career")
public class CareerController {
    @Autowired
    private CareerService careerService;
    @GetMapping
    public ResponseEntity<?> findAll(
    ) {
        return ResponseEntity.ok(
                new ResponseObject(careerService.findAll()));
    }

    @GetMapping("/{careerId}")
    public ResponseEntity<?> findById(@PathVariable Long careerId) {
        return ResponseEntity.ok(new ResponseObject(careerService.findById(careerId)));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CareerDto dto) {
        return ResponseEntity.ok().body(
                new ResponseObject(careerService.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CareerDto dto) {
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(careerService.update(dto))));
    }

    @DeleteMapping("/{careerId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable long careerId) {
        return ResponseEntity.ok(new ResponseObject(careerService.delete(careerId)));
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
                new ResponseObject(careerService.findWithFilter(id, name, description, paging)));
    }
}
