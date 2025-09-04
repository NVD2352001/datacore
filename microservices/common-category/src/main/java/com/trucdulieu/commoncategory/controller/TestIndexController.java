package com.trucdulieu.commoncategory.controller;
import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.dto.TestIndexDto;
import com.trucdulieu.commoncategory.service.interfaces.TestIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test_index")
public class TestIndexController {
    @Autowired
    private TestIndexService testIndexService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(new ResponseObject(testIndexService.findAll()));
    }

    @GetMapping("/{testindexId}")
    public ResponseEntity<?> findById(@PathVariable Long testindexId) {
        return ResponseEntity.ok(new ResponseObject(testIndexService.findById(testindexId)));
    }

    @PostMapping
    public ResponseEntity<?> creat(@RequestBody TestIndexDto dto) {
        return ResponseEntity.ok(new ResponseObject(testIndexService.add(dto)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TestIndexDto dto) {
        return ResponseEntity.ok(new ResponseObject(testIndexService.update(dto)));
    }

    @DeleteMapping("/{testindexId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable long testindexId) {
        return ResponseEntity.ok(new ResponseObject(testIndexService.delete(testindexId)));
    }

    @GetMapping(Constant.FILTER)
    ResponseEntity<?> findWithFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false) Double referenceValue,
            @RequestParam(required = false) Double unit,
            @RequestParam(defaultValue = Constant.PAGE_DEFAULT) Integer page,
            @RequestParam(defaultValue = Constant.LIMIT_DEFAULT) Integer limit,
            @RequestParam(defaultValue = Constant.SORT_INCREMENT) Integer direction,
            @RequestParam(defaultValue = Constant.DEFAULT_SORT_FIELD) String sortField) {
        Pageable paging = PageRequest.of(
                page, limit,
                Sort.by(direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        return ResponseEntity.ok(
                new ResponseObject(testIndexService.findWithFilter(id, name, description, referenceValue,unit, paging)));
    }

}
