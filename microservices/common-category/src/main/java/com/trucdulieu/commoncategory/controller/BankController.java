// package com.trucdulieu.commoncategory.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.trucdulieu.commoncategory.model.dto.BankDto;
// import com.trucdulieu.commoncategory.model.entity.Bank;
// import com.trucdulieu.commoncategory.service.BankService;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/bank")
// @RequiredArgsConstructor
// public class BankController {
//     private final BankService bankService;
//     @GetMapping
//     public List<Bank> getAll(
//     ){
//         return bankService.getBanks();
//     }

//     // NO: exists -> update, otherwise -> create
//     @PostMapping
//     public BankDto create(@RequestBody BankDto dto){
//         return bankService.create(dto);
//     }

//     @PutMapping
//     public BankDto update(@RequestBody BankDto dto){
//         // exists -> update, otherwise -> error
//         return bankService.update(dto);
//     }

// }
