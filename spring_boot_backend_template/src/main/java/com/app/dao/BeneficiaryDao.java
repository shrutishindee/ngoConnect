package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Beneficiary;

public interface BeneficiaryDao extends JpaRepository<Beneficiary, Long>{

}
