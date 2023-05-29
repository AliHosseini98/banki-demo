package com.example.banki.modules.bankBranch;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.customer.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankBranchConvertor {
    public BankBranchDTO entitytoDto(BankBranch branchb) {
        BankBranchDTO dto = BankBranchDTO.build(branchb.getId(), branchb.getName(),
                String.valueOf(branchb.getAddress()), branchb.getEmployees());
        return dto;
    }

    public List<BankBranchDTO> branchDTOList(List<BankBranch> bankBranchList) {
        return bankBranchList.stream().map(x -> entitytoDto(x)).collect(Collectors.toList());
    }


    public String dtoForSave(BankBranch branch){
        String branchDto =
                String.valueOf(" code is: " + branch.getId() +"\n"
                        + " name is: " +branch.getName()+"\n"
                        +  "address is: "  + branch.getAddress());
        return branchDto;
    }
}

