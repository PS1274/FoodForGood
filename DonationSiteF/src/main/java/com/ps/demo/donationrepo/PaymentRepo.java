package com.ps.demo.donationrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ps.demo.DonationEntity.PaymentEntity;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity,Integer>{

}
