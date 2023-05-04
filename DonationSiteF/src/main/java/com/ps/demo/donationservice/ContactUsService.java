package com.ps.demo.donationservice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ps.demo.DonationEntity.ContactUsEntity;
import com.ps.demo.DonationEntity.DonateEntity;
import com.ps.demo.donationrepo.ContactUsRepo;
import com.ps.demo.donationrepo.DonationRepo;

@Service
public class ContactUsService {
	@Autowired
	private ContactUsRepo repoz;
	
 public void addEmp(ContactUsEntity e) {
	 repoz.save(e);
 }
 
 public List<ContactUsEntity>getALLEmp(){
	 return repoz.findAll();
 }
 
 public ContactUsEntity getEmpById(int id) {
	Optional<ContactUsEntity>e= repoz.findById(id);
	if(e.isPresent()) {
		return e.get();
	}
	return null;
 }
 public void deleteEMp(int id) {
	 repoz.deleteById(id);
	}

}
