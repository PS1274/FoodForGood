package com.ps.demo.donationservice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ps.demo.DonationEntity.PaymentEntity;

import com.ps.demo.donationrepo.PaymentRepo;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepo repoz;
	
 public void addEmp(PaymentEntity e) {
	 repoz.save(e);
 }
 
 public List<PaymentEntity>getALLEmp(){
	 return repoz.findAll();
 }
 
 public PaymentEntity getEmpById(int id) {
	Optional<PaymentEntity>e= repoz.findById(id);
	if(e.isPresent()) {
		return e.get();
	}
	return null;
 }
 public void deleteEMp(int id) {
	 repoz.deleteById(id);
	}

}
