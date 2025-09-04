package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.DepartmentDto;
import com.trucdulieu.commoncategory.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok().body(new ResponseObject(departmentService.create(departmentDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments(){
        return ResponseEntity.ok().body(new ResponseObject(departmentService.getDepartments()));
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long departmentId){
        return ResponseEntity.ok().body(new ResponseObject(departmentService.getById(departmentId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok().body(new ResponseObject(departmentService.update(departmentDto)));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId){
        return ResponseEntity.ok().body(new ResponseObject(departmentService.delete(departmentId)));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterDepartments(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(new ResponseObject(departmentService.filterDepartments(id, name, pageable)));
    }
}
