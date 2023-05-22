package com.example.banki.modules.bankBranch.controller;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.bankBranch.service.BankBranchService;
import com.example.banki.modules.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bank")
public class BankBranchController {
    private final BankBranchService bankBranchService;

    public BankBranchController(BankBranchService bankBranchService) {
        this.bankBranchService = bankBranchService;
    }

    @PostMapping("/new")
    @ResponseBody
    public BankBranch CreateBranch(@RequestBody BankBranch bankBranch) {
        return bankBranchService.save(bankBranch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        bankBranchService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{bankId}/{empId}")
    @ResponseBody
    public BankBranch addEmpToBank(@PathVariable int bankId, @PathVariable int empId) {
        return bankBranchService.addEmpToBank(bankId, empId);
    }

    @GetMapping("/get/emp/{id}")
    @ResponseBody
    List<Employee> getEmployyesById(@PathVariable int id){
        return bankBranchService.getEmployeesByBankId(id);
    }

}
