package com.app.service;

import java.util.List;

import com.app.dto.BeneficiaryDto;
import com.app.pojos.Beneficiary;

public interface BeneficiaryService {
    List<BeneficiaryDto> getBeneficiaries();
    BeneficiaryDto getBeneficiary(Long beneficiary_id);
    String addBeneficiary(BeneficiaryDto beneficiary);
    String updateBeneficiary(Long beneficiary_id, BeneficiaryDto beneficiary);
    String deleteBeneficiary(Long beneficiary_id);
}
