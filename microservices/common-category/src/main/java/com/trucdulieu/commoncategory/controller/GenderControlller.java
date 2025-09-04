package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.GenderDto;
import com.trucdulieu.commoncategory.service.interfaces.GenderService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genders")
@RequiredArgsConstructor
public class GenderControlller {
    @Autowired
    private final GenderService genderService;
    @GetMapping
    public ResponseEntity<?> getAllGenders() {
        return ResponseEntity.ok(new ResponseObject(genderService.getGenders()));
    }
    @GetMapping("/{gendersId}")
    public ResponseEntity<?> getByGenderId(@PathVariable Long gendersId){
        return ResponseEntity.ok(new ResponseObject(genderService.getByGenderId(gendersId)));
    }
    @GetMapping(Constant.FILTER)
    public ResponseEntity<?> filterGender(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField){
        Pageable pageable = PageRequest.of(
                page,limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(genderService.filterGender(id,name,description, pageable)));
    }

    @PostMapping
    public ResponseEntity<?> createGender(@RequestBody GenderDto genderDto){
        return new ResponseEntity<>(genderService.createGender(genderDto),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> updateGender(@RequestBody GenderDto Dto){
        return ResponseEntity.ok(
                ResponseEntity.ok(new ResponseObject(genderService.updateGender(Dto))));
    }
    @DeleteMapping("/{gendersId}")
    public ResponseEntity<?> deteleGender(@PathVariable Long gendersId){
        genderService.deleteGender(gendersId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
