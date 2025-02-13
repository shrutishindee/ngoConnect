package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customExceptions.ResourceNotFoundException;
import com.app.dao.BeneficiaryDao;
import com.app.dao.EventDao;
import com.app.dto.BeneficiaryDto;
import com.app.pojos.Beneficiary;
import com.app.pojos.Event;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryDao beneficiaryDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EventDao eventdao;
    private Event event;
    
    @Autowired
    public BeneficiaryServiceImpl(EventDao eventDao) {
    	this.eventdao = eventDao;
    }


    @Override
    public List<BeneficiaryDto> getBeneficiaries() {
        List<Beneficiary> beneficiaries = beneficiaryDao.findAll();

        List<BeneficiaryDto> beneficiaryDtoList = beneficiaries.stream().map(beneficiary -> {
            BeneficiaryDto dto = modelMapper.map(beneficiary, BeneficiaryDto.class); 

            if (beneficiary.getEvent() != null) {
                dto.setEventId(beneficiary.getEvent().getEventId()); 
            }

            return dto;
        }).collect(Collectors.toList());

        return beneficiaryDtoList; // Corrected return statement
    }


    @Override
    public BeneficiaryDto getBeneficiary(Long beneficiary_id) {
    	Beneficiary beneficiary =  beneficiaryDao.findById(beneficiary_id).orElseThrow(() -> new ResourceNotFoundException("No such beneficiary found"));
    	BeneficiaryDto beneficiarydto = modelMapper.map(beneficiary, BeneficiaryDto.class);
    	if(beneficiary.getEvent()!=null) {
    		beneficiarydto.setEventId(beneficiary.getEvent().getEventId());
    	}
        return beneficiarydto ;
    }

    @Override
    public String addBeneficiary(BeneficiaryDto beneficiary) {
    	Event event = eventdao.findById(beneficiary.getEventId()).orElseThrow(() -> new ResourceNotFoundException("Event not fount with ID: " + beneficiary.getEventId()));
		Beneficiary beneficiarys = modelMapper.map(beneficiary, Beneficiary.class);
		beneficiarys.setEvent(event);
        beneficiaryDao.save(beneficiarys);
        return "New Beneficiary added";
    }

    @Override
    public String updateBeneficiary(Long beneficiary_id, BeneficiaryDto beneficiary) {
        if (beneficiaryDao.existsById(beneficiary_id)) {
        	Beneficiary beneficiarys = modelMapper.map(beneficiary, Beneficiary.class);
        	Event event = eventdao.findById(beneficiary.getEventId()).orElseThrow(() -> new ResourceNotFoundException("Event not fount with ID: " + beneficiary.getEventId()));
    		
    		beneficiarys.setEvent(event);
            beneficiaryDao.save(beneficiarys);
            return "Beneficiary updated";
        }
        throw new ResourceNotFoundException("Beneficiary doesn't exist");
    }

    @Override
    public String deleteBeneficiary(Long beneficiary_id) {
        if (beneficiaryDao.existsById(beneficiary_id)) {
            beneficiaryDao.deleteById(beneficiary_id);
            return "Beneficiary deleted";
        }
        throw new ResourceNotFoundException("Beneficiary doesn't exist");
    }
}
