package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.HISDto;
import com.trucdulieu.commoncategory.service.interfaces.HISService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/healthInsuranceSubject")
@RequiredArgsConstructor
public class HISController {
    @Autowired
    private HISService hisService;

    @PostMapping
    public ResponseEntity<?> createHIS(@RequestBody HISDto hisDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(hisService.create(hisDto)));
    }
    @PutMapping("/{hisId}")
    public ResponseEntity<?> updateHIS(@PathVariable Long hisId, @RequestBody HISDto hisDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(hisService.update(hisId, hisDto)));
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok()
                .body(new ResponseObject(hisService.findAll()));
    }
    @GetMapping("/filter")
    public ResponseEntity<?> filterHISs(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = " ") String name,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) int limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) int direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ){
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction ==0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok()
                .body(new ResponseObject(hisService.filterHISs(id, name, pageable)));
    }
    @DeleteMapping("/{hisId}")
    public ResponseEntity<?> deleteHIS(@PathVariable Long hisId, @RequestBody  HISDto hisDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(hisService.delete(hisId)));
    }
    @GetMapping("/{hisId}")
    public ResponseEntity<?> getHISById(@PathVariable Long hisId){
        return ResponseEntity.ok()
                .body(new ResponseObject(hisService.getById(hisId)));
    }

}
