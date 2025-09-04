package com.trucdulieu.commoncategory.controller;

import com.trucdulieu.commoncategory.base.ResponseObject;
import com.trucdulieu.commoncategory.model.dto.ChemicalInteractionDto;
import com.trucdulieu.commoncategory.service.interfaces.ChemicalInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chemical_interaction")
public class ChemicalInteractionController {
    @Autowired
    private ChemicalInteractionService chemicalInteractionService;

    @PostMapping
    public ResponseEntity<?> createChemicalInteraction(@RequestBody ChemicalInteractionDto chemicalInteractionDto){
        return ResponseEntity.ok().body(new ResponseObject(chemicalInteractionService.create(chemicalInteractionDto)));
    }

    @GetMapping
    public ResponseEntity<?> getAllChemicalInteractions(){
        return ResponseEntity.ok().body(new ResponseObject(chemicalInteractionService.getChemicalInteraction()));
    }

    @GetMapping("/{chemicalInteractionId}")
    public ResponseEntity<?> getChemicalInteractionById(@PathVariable Long chemicalInteractionId){
        return ResponseEntity.ok().body(new ResponseObject(chemicalInteractionService.getById(chemicalInteractionId)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateChemicalInteraction(@RequestBody ChemicalInteractionDto chemicalInteractionDto){
        return ResponseEntity.ok().body(new ResponseObject(chemicalInteractionService.update(chemicalInteractionDto)));
    }

    @DeleteMapping("/{chemicalInteractionId}")
    public ResponseEntity<?> deleteChemicalInteraction(@PathVariable Long chemicalInteractionId){
        return ResponseEntity.ok().body(new ResponseObject(chemicalInteractionService.delete(chemicalInteractionId)));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterChemicalInteractions(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "interaction", required = false) String interaction,
            @RequestParam(value = "creator", required = false) String creator,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(new ResponseObject(chemicalInteractionService.filterChemicalInteractions(id, name, code, interaction, creator, pageable)));
    }

}
