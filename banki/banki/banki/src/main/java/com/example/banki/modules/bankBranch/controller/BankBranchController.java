package com.example.banki.modules.bankBranch.controller;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.bankBranch.service.BankBranchService;
import com.example.banki.modules.employee.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bank")
@Slf4j
public class BankBranchController {
    private final BankBranchService bankBranchService;

    public BankBranchController(BankBranchService bankBranchService) {
        this.bankBranchService = bankBranchService;
    }

    @PostMapping("/new")
    @ResponseBody
    public String CreateBranch(@RequestBody BankBranch bankBranch) {
        return bankBranchService.save(bankBranch);
    }

    @DeleteMapping({"/",""})
    public ResponseEntity<?> delete(@RequestParam int id) {
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
    List<Employee> getEmployyesById(@PathVariable int id) {

        return bankBranchService.getEmployeesByBankId(id);
    }


}

