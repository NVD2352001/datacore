package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.BankDto;
import com.trucdulieu.commoncategory.service.interfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankNewController {
    @Autowired
    private BankService bankInterfaceService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(new ResponseObject(bankInterfaceService.findAll()));
    }

    @GetMapping("/{bankId}")
    public ResponseEntity<?> findById(@PathVariable Long bankId) {
        return ResponseEntity.ok(new ResponseObject(bankInterfaceService.findById(bankId)));
    }

    @PostMapping
    public ResponseEntity<?> creat(@RequestBody BankDto dto) {
        return ResponseEntity.ok(new ResponseObject(bankInterfaceService.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BankDto dto) {
        return ResponseEntity.ok(new ResponseObject(bankInterfaceService.update(dto)));
    }

    @DeleteMapping("/{bankId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable long id) {
        return ResponseEntity.ok(new ResponseObject(bankInterfaceService.delete(id)));
    }

    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(required = false, defaultValue = "") String bin,
            @RequestParam(required = false, defaultValue = "") String swiftCode,
            @RequestParam(required = false, defaultValue = "") String shortName,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable paging = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(bankInterfaceService.findWithFilter(id, name, description, code, bin, shortName, swiftCode, paging)));
    }
}
