package com.ps.demo.donationrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ps.demo.DonationEntity.ContactUsEntity;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUsEntity,Integer>{

}
