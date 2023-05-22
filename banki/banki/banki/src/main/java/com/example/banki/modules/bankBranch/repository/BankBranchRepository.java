package com.example.banki.modules.bankBranch.repository;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BankBranchRepository extends JpaRepository<BankBranch,Integer> {



}
