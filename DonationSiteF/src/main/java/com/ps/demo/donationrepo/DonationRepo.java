package com.ps.demo.donationrepo;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.ps.demo.DonationEntity.DonateEntity;

	@Repository
	public interface DonationRepo extends JpaRepository<DonateEntity,Integer>{

	}

