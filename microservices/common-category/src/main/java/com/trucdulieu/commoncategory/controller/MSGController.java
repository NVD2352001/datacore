package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.MSGDto;
import com.trucdulieu.commoncategory.service.interfaces.MSGService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Medical_Supply_Group")
@RequiredArgsConstructor
public class MSGController {
    @Autowired
    private MSGService msgService;
    @PostMapping
    public ResponseEntity<?> createMSG(@RequestBody MSGDto msgDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(msgService.create(msgDto)));
    }
    @PutMapping("/{msgId}")
    public ResponseEntity<?> updateMSG(@PathVariable Long msgId, @RequestBody MSGDto msgDto){
        return ResponseEntity.ok()
                .body(new ResponseObject(msgService.update(msgId, msgDto)));
        }
    @GetMapping
    public ResponseEntity<?> getAllMSG() {
        return ResponseEntity.ok()
                .body(new ResponseObject(msgService.getMSG()));
    }
    @GetMapping (Constant.FILTER)
    public ResponseEntity<?> filterMSG(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "", required = false) String name,
            @RequestParam(defaultValue = "", required = false) String code,
            @RequestParam(defaultValue = "", required = false) String description,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) int page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) int limit,
            @RequestParam(defaultValue = Constant.SORT_DIRECTION) int direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField
    ){
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction ==0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok()
                .body(new ResponseObject(msgService.filterMSG(id, name, code, description, pageable)));
    }
    @DeleteMapping("/{msgId}")
    public ResponseEntity<?> deleteMSG(@PathVariable Long msgId){
        return ResponseEntity.ok()
                .body(new ResponseObject(msgService.delete(msgId)));
    }
    @GetMapping("/{msgId}")
    public ResponseEntity<?> getMSGById(@PathVariable Long msgId){
        return ResponseEntity.ok()
                .body(new ResponseObject(msgService.getById(msgId)));
    }
}
