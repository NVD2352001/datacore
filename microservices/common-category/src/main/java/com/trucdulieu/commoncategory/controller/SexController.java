package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.SexDto;
import com.trucdulieu.commoncategory.service.interfaces.SexSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sex")
@CrossOrigin
public class SexController {

    @Autowired
    private SexSevice service;

    @GetMapping
    public ResponseEntity<ResponseObject> findAll(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ) {
        // logic recode in service
        Pageable paging = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField)
        );
        Page<SexDto> units = name.equals("") ?
                service.findByName(paging) : service.findByName(name, paging);
        return ResponseEntity.ok(
                new ResponseObject(units)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseObject(service.findById(id)));
    }


    @PostMapping
    public ResponseEntity<ResponseObject> insert(@RequestBody SexDto dto) {
        if (dto.getId() != null)
            return ResponseEntity.ok().body(
                    new ResponseObject(null)
            );
        try {
            SexDto insert = service.add(dto);
            return insert != null ?
                    ResponseEntity.ok().body(
                            new ResponseObject(insert)
                    )
                    : ResponseEntity.ok().body(
                    new ResponseObject(null)
            );
        } catch (DataAccessException e) {
            return ResponseEntity.ok().body(
                    new ResponseObject(e.getMessage())
            );
        }
    }

    @PutMapping
    public ResponseEntity<ResponseObject> update(@RequestBody SexDto dto) {
        SexDto update = service.update(dto);
        return update == null ?
                ResponseEntity.ok(
                        new ResponseObject(null)
                )
                : ResponseEntity.ok(
                new ResponseObject(update)
        );
    }

    @DeleteMapping("/{sexId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long sexId) {
        return ResponseEntity.ok(new ResponseObject(service.delete(sexId)));
    }
}
