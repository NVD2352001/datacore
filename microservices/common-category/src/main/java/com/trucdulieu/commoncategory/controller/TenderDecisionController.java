package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.TenderDecisionDto;
import com.trucdulieu.commoncategory.service.interfaces.TenderDecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tender_decision")
public class TenderDecisionController {
    @Autowired
    private TenderDecisionService tenderDecisionService;
    @PostMapping
    public ResponseEntity<?> createTenderDecision(@RequestBody TenderDecisionDto tenderDecisionDto){
        return ResponseEntity.ok().body(new ResponseObject(tenderDecisionService.create(tenderDecisionDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllTenderDecisions(){
        return ResponseEntity.ok().body(new ResponseObject(tenderDecisionService.getTenderDecision()));
    }

    @GetMapping("/{tenderDecisionId}")
    public ResponseEntity<?> getTenderDecisionById(@PathVariable Long tenderDecisionId){
        return ResponseEntity.ok().body(new ResponseObject(tenderDecisionService.getById(tenderDecisionId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTenderDecision(@RequestBody TenderDecisionDto tenderDecisionDto){
        return ResponseEntity.ok().body(new ResponseObject(tenderDecisionService.update(tenderDecisionDto)));
    }

    @DeleteMapping("/{tenderDecisionId}")
    public ResponseEntity<?> deleteTenderDecision(@PathVariable Long tenderDecisionId){
        return ResponseEntity.ok().body(new ResponseObject(tenderDecisionService.delete(tenderDecisionId)));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterTenderDecisions(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "unit", required = false) String unit,
            @RequestParam(value = "tenderNumber", required = false) String tenderNumber,
            @RequestParam(value = "decision", required = false) String decision,
            @RequestParam(value = "decisionDate", required = false) String decisionDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(new ResponseObject(tenderDecisionService.filterTenderDecisions(id, name, unit, tenderNumber, decision, decisionDate, pageable)));
    }
}
