package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BeneficiaryDto;
import com.app.pojos.Beneficiary;
import com.app.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping
    public ResponseEntity<?> getAllBeneficiaries() {
        List<BeneficiaryDto> beneficiaries = beneficiaryService.getBeneficiaries();
        if (beneficiaries.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(beneficiaries);
    }

    @GetMapping("/{beneficiary_id}")
    public ResponseEntity<?> getBeneficiary(@PathVariable Long beneficiary_id) {
        return ResponseEntity.ok(beneficiaryService.getBeneficiary(beneficiary_id));
    }

    @PostMapping
    public ResponseEntity<?> addNewBeneficiary(@RequestBody BeneficiaryDto beneficiary) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficiaryService.addBeneficiary(beneficiary));
    }

    @PutMapping("/{beneficiary_id}")
    public ResponseEntity<?> updateBeneficiary(@RequestBody BeneficiaryDto beneficiary, @PathVariable Long beneficiary_id) {
        return ResponseEntity.ok(beneficiaryService.updateBeneficiary(beneficiary_id, beneficiary));
    }

    @DeleteMapping("/{beneficiary_id}")
    public ResponseEntity<?> deleteBeneficiaryById(@PathVariable Long beneficiary_id) {
        return ResponseEntity.ok(beneficiaryService.deleteBeneficiary(beneficiary_id));
    }
}
