package com.ps.demo.donationservice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ps.demo.DonationEntity.DonateEntity;
import com.ps.demo.donationrepo.DonationRepo;

@Service
public class DonationService {
	@Autowired
	private DonationRepo repo;
	
 public void addEmp(DonateEntity e) {
	 repo.save(e);
 }
 
 public List<DonateEntity>getALLEmp(){
	 return repo.findAll();
 }
 
 public DonateEntity getEmpById(int id) {
	Optional<DonateEntity>e= repo.findById(id);
	if(e.isPresent()) {
		return e.get();
	}
	return null;
 }
 public void deleteEMp(int id) {
		repo.deleteById(id);
	}

}
